package com.teamnarita.sample.sampleserver.repository

import com.teamnarita.sample.sampleserver.model.GameUser
import org.springframework.stereotype.Repository


interface IUserRepository {
    fun find(): GameUser?
    fun save(): Boolean
}