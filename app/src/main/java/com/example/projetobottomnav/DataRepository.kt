package com.example.projetobottomnav

class DataRepository(private val dao: DataDao) {

    suspend fun insertInitialData() {

        dao.deleteAll()

        dao.insertChannel(
            DataClass(
                dataImage = R.drawable.test,
                dataTitle = "White Phosfor.",
                dataId = "@WhitePhos4"
            )
        )

        dao.insertChannel(
            DataClass(
                dataImage = R.drawable.levi,
                dataTitle = "AOT News",
                dataId = "@AotNews7"
            )
        )

        dao.insertChannel(
            DataClass(
                dataImage = R.drawable.ghost,
                dataTitle = "CoD Clips",
                dataId = "@CoDCClips01"
            )
        )

        dao.insertChannel(
            DataClass(
                dataImage = R.drawable.spiderman,
                dataTitle = "MCU Updater",
                dataId = "@MCUChannel"
            )
        )
        dao.insertChannel(
            DataClass(
                dataImage = R.drawable.garandthumb,
                dataTitle = "Garand Thumb",
                dataId = "@GarandThumb"
            )
        )
        dao.insertChannel(
            DataClass(
                dataImage = R.drawable.adminr,
                dataTitle = "Administrative Results",
                dataId = "@AdminResults"
            )
        )
        dao.insertChannel(
            DataClass(
                dataImage = R.drawable.bf6,
                dataTitle = "Battlefield",
                dataId = "@Battlefield"
            )
        )
    }


    suspend fun getAllChannels(): List<DataClass> {
        return dao.getAllChannels()
    }
}