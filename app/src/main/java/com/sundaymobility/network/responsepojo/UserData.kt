package com.sundaymobility.network.responsepojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserData(

    @SerializedName("login")
    @Expose
    private val login: String? = null,

    @SerializedName("id")
    @Expose
    private val id: Int? = null,

    @SerializedName("node_id")
    @Expose
    private val nodeId: String? = null,

    @SerializedName("avatar_url")
    @Expose
    private val avatarUrl: String? = null,

    @SerializedName("gravatar_id")
    @Expose
    private val gravatarId: String? = null,

    @SerializedName("url")
    @Expose
    private val url: String? = null,

    @SerializedName("html_url")
    @Expose
    private val htmlUrl: String? = null,

    @SerializedName("followers_url")
    @Expose
    private val followersUrl: String? = null,

    @SerializedName("following_url")
    @Expose
    private val followingUrl: String? = null,

    @SerializedName("gists_url")
    @Expose
    private val gistsUrl: String? = null,

    @SerializedName("starred_url")
    @Expose
    private val starredUrl: String? = null,

    @SerializedName("subscriptions_url")
    @Expose
    private val subscriptionsUrl: String? = null,

    @SerializedName("organizations_url")
    @Expose
    private val organizationsUrl: String? = null,

    @SerializedName("repos_url")
    @Expose
    private val reposUrl: String? = null,

    @SerializedName("events_url")
    @Expose
    private val eventsUrl: String? = null,

    @SerializedName("received_events_url")
    @Expose
    private val receivedEventsUrl: String? = null,

    @SerializedName("type")
    @Expose
    private val type: String? = null,

    @SerializedName("site_admin")
    @Expose
    private val siteAdmin: Boolean? = null

)

