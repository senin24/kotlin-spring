package com.git.senin24.kotlinpoc.csvtobd.service

import com.git.senin24.kotlinpoc.csvtobd.config.GeomProperties
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

@Service
class FileServiceImpl(
        private val geomProp: GeomProperties
) : FileService {

    override fun getDoneFileName(): String? {
        return File(geomProp.tfsPath).walk().first { file -> "done" == file.extension }.nameWithoutExtension
    }

    override fun moveFileFromTfsToFir(fileName: String) {
        val copiedFile = Paths.get(geomProp.tfsPath).resolve(fileName)
        val targetFile = Paths.get(geomProp.firPath).resolve(fileName)
        Files.move(copiedFile, targetFile)
    }
}