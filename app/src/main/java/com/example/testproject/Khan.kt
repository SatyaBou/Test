package com.example.testproject

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Khan(
    @PrimaryKey
    var id: Int = 0,
    var name: String = ""
) : RealmObject()
