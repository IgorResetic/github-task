package com.example.githubtask.persistence.mappers

import com.example.githubtask.models.database.GItHubRepoEntity
import com.example.githubtask.models.domain.GitHubRepo
import com.example.githubtask.util.EntityMapper
import javax.inject.Inject

class GitHubRepoMapper
@Inject
constructor() : EntityMapper<GItHubRepoEntity, GitHubRepo> {
    override fun mapFromEntity(entity: GItHubRepoEntity): GitHubRepo {
        return GitHubRepo(
            id = entity.id,
            name = entity.name,
            fullName = entity.fullName,
            owner = entity.owner,
            htmlUrl = entity.htmlUrl,
            description = entity.description,
            stargazersCount = entity.starsCount,
            watchersCount = entity.watchersCount,
            forksCount = entity.forksCount,
            language = entity.language,
            openIssuesCount = entity.openIssuesCount,
            updatedAt = entity.updatedAt,
            createdAt = entity.createdAt
        )
    }

    override fun mapToEntity(domainModel: GitHubRepo): GItHubRepoEntity {
        return GItHubRepoEntity(
            id = domainModel.id,
            name = domainModel.name,
            fullName = domainModel.fullName,
            owner = domainModel.owner,
            htmlUrl = domainModel.htmlUrl,
            description = domainModel.description,
            starsCount = domainModel.stargazersCount,
            watchersCount = domainModel.watchersCount,
            forksCount = domainModel.forksCount,
            language = domainModel.language,
            openIssuesCount = domainModel.openIssuesCount,
            updatedAt = domainModel.updatedAt,
            createdAt = domainModel.createdAt
        )
    }

    fun mapFromEntityList(entities: List<GItHubRepoEntity>): List<GitHubRepo> {
        return entities.map { mapFromEntity(it) }
    }
}
