package com.example.githubtask.network.mappers

import com.example.githubtask.models.api.GitHubRepoNetworkEntity
import com.example.githubtask.models.domain.GitHubRepo
import com.example.githubtask.util.EntityMapper
import javax.inject.Inject

class GitHUbRepoNetworkMapper
@Inject
constructor() : EntityMapper<GitHubRepoNetworkEntity, GitHubRepo> {
    override fun mapFromEntity(entity: GitHubRepoNetworkEntity): GitHubRepo {
        return GitHubRepo(
            id = entity.id,
            name = entity.name,
            fullName = entity.fullName,
            owner = entity.owner,
            htmlUrl = entity.htmlUrl,
            description = entity.description,
            stargazersCount = entity.stargazersCount,
            watchersCount = entity.watchersCount,
            forksCount = entity.forksCount,
            language = entity.language,
            openIssuesCount = entity.openIssuesCount,
            updatedAt = entity.updatedAt,
            createdAt = entity.createdAt
        )
    }

    override fun mapToEntity(domainModel: GitHubRepo): GitHubRepoNetworkEntity {
        return GitHubRepoNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            fullName = domainModel.fullName,
            owner = domainModel.owner,
            htmlUrl = domainModel.htmlUrl,
            description = domainModel.description,
            stargazersCount = domainModel.stargazersCount,
            watchersCount = domainModel.watchersCount,
            forksCount = domainModel.forksCount,
            language = domainModel.language,
            openIssuesCount = domainModel.openIssuesCount,
            updatedAt = domainModel.updatedAt,
            createdAt = domainModel.createdAt
        )
    }

    fun mapFromEntityList(entities: List<GitHubRepoNetworkEntity>): List<GitHubRepo> {
        return entities.map { mapFromEntity(it) }
    }
}
