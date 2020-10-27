package com.example.githubtask.persistence.mappers

import com.example.githubtask.models.database.UserEntity
import com.example.githubtask.models.domain.User
import com.example.githubtask.util.EntityMapper
import javax.inject.Inject

class UserMapper
@Inject
constructor() : EntityMapper<UserEntity, User> {
    override fun mapFromEntity(entity: UserEntity): User {
        return User(
            login = entity.login,
            avatarUrl = entity.avatarUrl,
            htmlUrl = entity.htmlUrl,
            name = entity.name,
            location = entity.location,
            bio = entity.bio,
            publicRepo = entity.publicRepo,
            reposUrl = entity.reposUrl,
            followers = entity.followers,
            following = entity.following
        )
    }

    override fun mapToEntity(domainModel: User): UserEntity {
        return UserEntity(
            login = domainModel.login,
            avatarUrl = domainModel.avatarUrl,
            htmlUrl = domainModel.htmlUrl,
            name = domainModel.name,
            location = domainModel.location,
            bio = domainModel.bio,
            publicRepo = domainModel.publicRepo,
            reposUrl = domainModel.reposUrl,
            followers = domainModel.followers,
            following = domainModel.following
        )
    }
}
