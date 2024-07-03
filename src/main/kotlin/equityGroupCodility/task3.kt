package equityGroupCodility

import kotlinx.coroutines.*
import java.io.Closeable

class AggregateUserDataUseCase1(
    private val resolveCurrentUser: suspend () -> UserEntity,
    private val fetchUserComments: suspend (UserId) -> List<CommentEntity>,
    private val fetchSuggestedFriends: suspend (UserId) -> List<FriendEntity>
) : Closeable, AggregateUseCase {

    private val job = SupervisorJob()

    override suspend fun aggregateDataForCurrentUser(): AggregatedData {
        val user: UserEntity
        try {
            user = resolveCurrentUser()
        } catch (e: Exception) {
            throw e // Forward the exception
        }

        val commentsDeferred = runBlocking (job) {
            withTimeoutOrNull(2000) {
                try {
                    fetchUserComments(user.id)
                } catch (e: Exception) {
                    emptyList() // Handle exception with empty list
                }
            } ?: emptyList()
        }

        val suggestedFriendsDeferred = runBlocking(job) {
            withTimeoutOrNull(2000) {
                try {
                    fetchSuggestedFriends(user.id)
                } catch (e: Exception) {
                    emptyList() // Handle exception with empty list
                }
            } ?: emptyList()
        }

        return AggregatedData(user, commentsDeferred, suggestedFriendsDeferred)
    }

    override fun close() {
        job.cancel()
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

interface AggregateUseCase{
    suspend fun aggregateDataForCurrentUser(): AggregatedData
}
