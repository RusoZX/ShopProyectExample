package com.rzxengineering.shopapp.services

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder


import java.net.ConnectException

 class Conexion {
    var channel: ManagedChannel? = null
    //Security.insertProviderAt(Conscrypt.newProvider(),1)

    init{
        try{
            channel=ManagedChannelBuilder.forAddress("192.168.0.14",9090)
                .usePlaintext().build()
        }catch(e: ConnectException){
            throw ConnectException()
        }
    }
}