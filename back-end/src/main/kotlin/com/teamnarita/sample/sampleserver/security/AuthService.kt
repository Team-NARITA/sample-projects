package com.teamnarita.sample.sampleserver.security

import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.teamnarita.sample.sampleserver.repository.IUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthService(@Autowired private val userRepository: IUserRepository): AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    private val firebaseApp = FirebaseAuth.getInstance()
    override fun loadUserDetails(token: PreAuthenticatedAuthenticationToken): UserDetails {
        val credential = token.credentials.toString()

        if (credential.isEmpty()) throw BadCredentialsException("トークンが空です")

        try {
            val firebaseToken = firebaseApp.verifyIdToken(credential)
            return User(firebaseToken.email, "", AuthorityUtils.NO_AUTHORITIES)
        } catch (e: FirebaseException) {
            throw BadCredentialsException("トークン検証エラー", e)
        }
    }
}