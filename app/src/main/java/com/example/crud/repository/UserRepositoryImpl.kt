package br.com.asaplog.data.repository.bff

import com.example.crud.localdatasource.daos.UserItemDao
import com.example.crud.localdatasource.entitys.UserEntity
import com.example.crud.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(
    private val userDao: UserItemDao
) : UserRepository {
    override suspend fun createUser(userItem: UserEntity): Result<UserEntity> {
        return withContext(Dispatchers.IO) {
            try {
                val id = userDao.insert(userItem)
                if (id > 0) {
                    Result.success(userItem.copy(uid = id.toInt()))
                } else {
                    Result.failure(Throwable("Erro ao inserir usuário"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    override suspend fun getUserById(id: Int): Result<UserEntity> {
        return withContext(Dispatchers.IO) {
            try {
                val user = userDao.getById(id)
                if (user != null) {
                    Result.success(user)
                } else {
                    Result.failure(Throwable("Usuário não encontrado"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    override suspend fun getAllUsers(): Result<List<UserEntity>> {
        return withContext(Dispatchers.IO) {
            try {
                val users = userDao.getAll()
                Result.success(users)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    override suspend fun updateUser(id: Int, userItem: UserEntity): Result<UserEntity> {
        return withContext(Dispatchers.IO) {
            try {
                userDao.update(userItem)
                Result.success(userItem)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    override suspend fun deleteUser(id: Int): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                val user = userDao.getById(id)
                if (user != null) {
                    userDao.delete(user)
                    Result.success(Unit)
                } else {
                    Result.failure(Throwable("Usuário não encontrado"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}
