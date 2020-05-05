package com.git.senin24.kotlinpoc.csvtobd.service

import com.git.senin24.kotlinpoc.csvtobd.config.GeomProperties
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.file.Paths
import java.util.zip.ZipEntry
import java.util.zip.ZipFile


@Service
class ParsingServiceImpl(
        private val geomProp: GeomProperties
) : ParsingService {

    override fun parseZipWithCsv(fileName: String) {

        ZipFile(Paths.get(geomProp.firPath).resolve(fileName).toFile()).use { zip ->
            zip.entries().asSequence()
                    .filter { entry -> entry.name.contains(".csv") }
                    .forEach { entry ->
                        zip.getInputStream(entry)
                                .use { input ->
                                    readEachLine(input, entry)
                                }
                    }
        }


    }

    private fun readEachLine(input: InputStream, entry: ZipEntry) {
        input.bufferedReader().useLines {
            lines -> lines.forEach {
                line -> println("File name: ${entry.name} with line: $line") }
        }
    }

    private fun parseLine(line: String, fileName: String) {
        println("File name: $fileName with line: $line")
        TODO("Not yet implemented")
    }
}