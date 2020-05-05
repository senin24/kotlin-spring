package com.git.senin24.kotlinpoc.csvtobd.service

interface FileService {

    fun getDoneFileName(): String?

    fun moveFileFromTfsToFir(fileName: String)
}