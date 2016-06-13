package co.instameals.dinnersolutions.api.v2

import android.content.SharedPreferences

class AuthManager (val sharedPreferences: SharedPreferences) {

    fun saveBearerToken(token: String) {
        sharedPreferences
                .edit()
                .putString("bearer_token", token)
                .apply()
    }

    fun getBearerToken(): String {
        return sharedPreferences.getString("bearer_token", "")
    }

    fun isAuthenticated(): Boolean {
        return !getBearerToken().isEmpty()
    }
}