package com.teamnarita.sample.sampleserver.repository

import com.teamnarita.sample.sampleserver.model.GameUser
import org.springframework.stereotype.Repository

@Repository
class UserRepository: IUserRepository {
    override fun find(): GameUser? {
        TODO("Not yet implemented")
    }

    override fun save(): Boolean {
        TODO("Not yet implemented")
    }
}