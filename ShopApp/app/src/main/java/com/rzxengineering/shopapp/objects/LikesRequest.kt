package com.rzxengineering.shopapp.objects

data class LikesRequest(var ids :ArrayList<Int>, var idClient: Int) {
    override fun toString(): String {
        return "Ids: $ids, idClient=$idClient"
    }
}