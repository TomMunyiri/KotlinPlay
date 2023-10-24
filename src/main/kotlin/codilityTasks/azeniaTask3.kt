package codilityTasks

import kotlinx.coroutines.*
import java.io.Closeable

class AggregateUserDataUseCase1(
    private val resolveCurrentUser: suspend () -> UserEntity,
    private val fetchUserComments: suspend (UserId) -> List<CommentEntity>,
    private val fetchSuggestedFriends: suspend (UserId) -> List<FriendEntity>
) : Closeable, AggregateUserDataUseCase {

    private val scope = CoroutineScope(Dispatchers.Default)
    private val cancellationScope = CoroutineScope(Job()) // Additional scope for handling cancellation

    override suspend fun aggregateDataForCurrentUser(): AggregatedData {
        return try {
            val user = resolveCurrentUser.invoke()
            val commentsDeferred = asyncWithTimeoutOrNull(2000) { fetchUserComments(user.id) }
            val friendsDeferred = asyncWithTimeoutOrNull(2000) { fetchSuggestedFriends(user.id) }

            AggregatedData(user, commentsDeferred ?: emptyList(), friendsDeferred ?: emptyList())
        } catch (e: Exception) {
            throw e // Forward the exception
        }
    }

    private suspend fun fetchUserComments(userId: UserId): List<CommentEntity> {
        return withTimeoutOrNull(2000) {
            delay(100)
            fetchUserComments.invoke(userId)
        } ?: emptyList()
    }

    private suspend fun fetchSuggestedFriends(userId: UserId): List<FriendEntity> {
        return withTimeoutOrNull(2000) {
            delay(100)
            fetchSuggestedFriends.invoke(userId)
        } ?: emptyList()
    }

    override fun close() {
        scope.cancel()
        cancellationScope.cancel()
    }

    private suspend fun <T> asyncWithTimeoutOrNull(timeout: Long, block: suspend () -> T): T? {
        return withTimeoutOrNull(timeout) {
            async { block.invoke() }.await()
        }
    }
}

data class AggregatedData(
    val user: UserEntity,
    val comments: List<CommentEntity>,
    val suggestedFriends: List<FriendEntity>
)

typealias UserId = String

data class UserEntity(val id: UserId, val name: String)

data class CommentEntity(val id: String, val content: String)

data class FriendEntity(val id: String, val name: String)

interface AggregateUserDataUseCase{
    suspend fun aggregateDataForCurrentUser(): AggregatedData
}
