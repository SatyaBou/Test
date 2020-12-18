package com.example.testproject

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class Commune(
        @PrimaryKey
        var id: Int? = 0,
        var khanId: Int? = 0,
        var name: String? = "",
        var postcode: String? = ""
) : RealmObject()