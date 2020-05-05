package com.git.senin24.kotlinpoc.csvtobd.service

import com.git.senin24.kotlinpoc.csvtobd.config.GeomProperties
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class WatchServiceImpl(
        private val geomProp: GeomProperties,
        private val fileService: FileService,
        private val parsingService: ParsingService
) : WatchService {

    @Scheduled(fixedDelay = 60_000 * 5)
    override fun watchDoneFile() {
        val currentTime = LocalDateTime.now()
        if (true ||
                currentTime.plusMinutes(5).hour % geomProp.appInstance == geomProp.expectedDivisionResult &&
                currentTime.minusMinutes(5).hour % geomProp.appInstance == geomProp.expectedDivisionResult &&
                currentAppNotLocked()
        ) {
            val fileName = fileService.getDoneFileName()
            if (fileName?.isNotEmpty()!!) {
                fileService.moveFileFromTfsToFir("$fileName.done")
                fileService.moveFileFromTfsToFir(fileName)
                waitUntilAnotherAppIsNotLocked()
                parsingService.parseZipWithCsv(fileName)
            }
        }
    }

    /**
     * Ждем пока другой инстанс не завершит работу.
     */
    private fun waitUntilAnotherAppIsNotLocked() {
        return
        TODO("Not yet implemented")
    }

    /**
     * Данный инстанс приложения занят работой? Проверяет запись в таблице
     */
    private fun currentAppNotLocked(): Boolean {
        return true
        TODO("Not yet implemented")
    }
}