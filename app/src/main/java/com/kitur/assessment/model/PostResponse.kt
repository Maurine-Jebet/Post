package com.kitur.assessment.model

class PostResponse {

    data class PostResponse (
        var post:List<Post>,
        var total:Int,
        var skip:Int,
        var limit:Int
    )

}