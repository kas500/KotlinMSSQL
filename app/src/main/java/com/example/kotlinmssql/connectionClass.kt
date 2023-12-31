package com.example.kotlinmssql

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class connectionClass {
    private val ip = "10.64.2.21" // your database server ip
    private val db = "CoWBCProd" // your database name
    private val username = "" // your database username
    private val password = "" // your database password
    private val connectionWin = "Integrated Security=true;"

    fun dbConn() : Connection? {

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn : Connection? = null
        var connString: String? = null
        try {
            Class.forName("net.sourgeforge.jtds.jdbc.Driver")
            connString = "jdbc:jtds:sqlserver://$ip;databaseName=$db;$connectionWin"
            conn = DriverManager.getConnection(connString)
        }catch (ex: SQLException){
            Log.e("Error : ", ex.message.toString())
        }catch (ex1: ClassNotFoundException){
            Log.e("Error : ", ex1.message.toString())
        }catch (ex2: Exception){
            Log.e("Error : ", ex2.message.toString())
        }

        return conn
    }
}