package com.example.githubtask.network.mappers

import com.example.githubtask.models.api.UserNetworkEntity
import com.example.githubtask.models.domain.User
import com.example.githubtask.util.EntityMapper
import javax.inject.Inject

class UserNetworkMapper
@Inject
constructor() : EntityMapper<UserNetworkEntity, User> {
    override fun mapFromEntity(entity: UserNetworkEntity): User {
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

    override fun mapToEntity(domainModel: User): UserNetworkEntity {
        return UserNetworkEntity(
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
