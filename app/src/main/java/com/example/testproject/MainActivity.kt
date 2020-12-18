package com.example.testproject

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.testproject.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import io.realm.Realm
import io.realm.RealmConfiguration

class MainActivity : AppCompatActivity() {

    private var realm: Realm? = null
    lateinit var binding: ActivityMainBinding
    val movieData = ArrayList<Khan>()
    val khanList = ArrayList<String>()
    val sangkatList = ArrayList<String>()
    val communeList = ArrayList<Commune>()

    var mBranchId: Int = 0


    private var khandroplist: ImageView? = null
    private var sangkatdroplist: ImageView? = null
    private var txtkhan: TextView? = null
    private var txtsangkat: TextView? = null
    private var txtPostCode: TextView? = null

    private var sharedPreferences: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Realm.init(this)
        val mConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(mConfiguration)
        realm = Realm.getDefaultInstance()
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.data = Khan()
        khanData()
        sangkatData()
        khandroplist = findViewById(R.id.khan_drop_list)
        sangkatdroplist = findViewById(R.id.sangkat_drop_list)
        txtkhan = findViewById(R.id.txt_khan)
        txtsangkat = findViewById(R.id.txt_sangkat)
        txtPostCode = findViewById(R.id.post_code)

        khandroplist?.setOnClickListener {
            setupKhan()
        }
        sangkatdroplist?.setOnClickListener {
            setupsangkat()

        }
        val hello = findViewById<TextInputEditText>(R.id.et_test)
        hello.setOnClickListener {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
        }

    }

    private fun khanData() {

        movieData.add(Khan(1, "Movie Chamkar Mon"))
        movieData.add(Khan(2, "Movie Doun Penh"))
        movieData.add(Khan(3, "Movie Prampir Meakakra"))
        movieData.add(Khan(4, "Movie Tuol Kouk"))
        movieData.add(Khan(5, "Movie Dangkao"))
        movieData.add(Khan(6, "Movie Mean chey"))
        movieData.add(Khan(7, "Movie Russey Keo"))
        movieData.add(Khan(8, "Movie Saensokh"))
        movieData.add(Khan(9, "Movie Pur Senchey"))
        movieData.add(Khan(10, "Movie Chrouy Changvar"))
        movieData.add(Khan(11, "Movie Preaek Pnov"))
        movieData.add(Khan(12, "Movie Chbar Ampov"))
        realm?.executeTransaction { realm ->
            realm.copyToRealmOrUpdate(movieData)
        }
    }

    private fun sangkatData() {

        // 1.1
        communeList.add(Commune(1, 1, "Sangkat Tonle Basak", "120101"))
        communeList.add(Commune(2, 1, "Sangkat Boeng Keng Kong 1", "120102"))
        communeList.add(Commune(3, 1, "Sangkat Boeng Keng Kong 2", "120103"))
        communeList.add(Commune(4, 1, "Sangkat Boeng Keng Kong 3", "120104"))
        communeList.add(Commune(5, 1, "Sangkat Olympic", "120105"))
        communeList.add(Commune(6, 1, "Sangkat Tuol Svay Prey 1", "120106"))
        communeList.add(Commune(7, 1, "Sangkat Tuol Svay Prey 2", "120107"))
        communeList.add(Commune(8, 1, "Sangkat Tumnob Tuek", "120108"))
        communeList.add(Commune(9, 1, "Sangkat Tuol Tumpung 1", "120109"))
        communeList.add(Commune(10, 1, "Sangkat Tuol Tumpung 2", "120110"))
        communeList.add(Commune(11, 1, "Sangkat Boeng Trabaek", "120111"))
        communeList.add(Commune(12, 1, "Sangkat Phsar Daeum Thkov", "120112"))
        // 2.1
        communeList.add(Commune(13, 2, "Sangkat Phsar Thei 1", "120201"))
        communeList.add(Commune(14, 2, "Sangkat Phsar Thei 2", "120202"))
        communeList.add(Commune(15, 2, "Sangkat Phsar Thei 3", "120203"))
        communeList.add(Commune(16, 2, "Sangkat Boeng Rang", "120204"))
        communeList.add(Commune(17, 2, "Sangkat Phsar Kandal 1", "120205"))
        communeList.add(Commune(18, 2, "Sangkat Phsar Kandal 2", "120206"))
        communeList.add(Commune(19, 2, "Sangkat Chakto Mukh", "120207"))
        communeList.add(Commune(20, 2, "Sangkat Chey Chumneah", "120208"))
        communeList.add(Commune(21, 2, "Sangkat Phsar Chas", "120209"))
        communeList.add(Commune(22, 2, "Sangkat Srah Chak", "120210"))
        communeList.add(Commune(23, 2, "Sangkat Voat Phnum", "120211"))
        // 3.1
        communeList.add(Commune(24, 3, "Sangkat Ou Ruessei 1", "120301"))
        communeList.add(Commune(25, 3, "Sangkat Ou Ruessei 2", "120302"))
        communeList.add(Commune(26, 3, "Sangkat Ou Ruessei 3", "120303"))
        communeList.add(Commune(27, 3, "Sangkat Ou Ruessei 4", "120304"))
        communeList.add(Commune(28, 3, "Sangkat Monourrom", "120305"))
        communeList.add(Commune(29, 3, "Sangkat Mittapheap", "120306"))
        communeList.add(Commune(30, 3, "Sangkat Veal Vong", "120307"))
        communeList.add(Commune(31, 3, "Sangkat Boeng Proluet", "120308"))
        // 4.1
        communeList.add(Commune(32, 4, "Sangkat Phsar Depou 1", "120401"))
        communeList.add(Commune(33, 4, "Sangkat Phsar Depou 2", "120402"))
        communeList.add(Commune(34, 4, "Sangkat Phsar Depou 3", "120403"))
        communeList.add(Commune(35, 4, "Sangkat Tuek L'ak 1", "120404"))
        communeList.add(Commune(36, 4, "Sangkat Tuek L'ak 2", "120405"))
        communeList.add(Commune(37, 4, "Sangkat Tuek L'ak 3", "120406"))
        communeList.add(Commune(38, 4, "Sangkat Boeng Kak 1", "120407"))
        communeList.add(Commune(39, 4, "Sangkat Boeng Kak 2", "120408"))
        communeList.add(Commune(40, 4, "Sangkat Phsar Daeum Kor", "120409"))
        communeList.add(Commune(41, 4, "Sangkat Boeng Salang", "120410"))
        // 5.1
        communeList.add(Commune(42, 5, "Sangkat Dangkao", "120501"))
        communeList.add(Commune(43, 5, "Sangkat Pong Tuek", "120502"))
        communeList.add(Commune(44, 5, "Sangkat Prey Veaeng", "120503"))
        communeList.add(Commune(45, 5, "Sangkat Prey Sa", "120504"))
        communeList.add(Commune(46, 5, "Sangkat Krang Pongro", "120505"))
        communeList.add(Commune(47, 5, "Sangkat Prateah Lang", "120506"))
        communeList.add(Commune(48, 5, "Sangkat Sak Sampov", "120507"))
        communeList.add(Commune(49, 5, "Sangkat Cheung Aek", "120508"))
        communeList.add(Commune(50, 5, "Sangkat Kong Noy", "120509"))
        communeList.add(Commune(51, 5, "Sangkat Preaek Kampues", "120510"))
        communeList.add(Commune(52, 5, "Sangkat Roluos", "120511"))
        communeList.add(Commune(53, 5, "Sangkat Spean Thma", "120512"))
        communeList.add(Commune(54, 5, "Sangkat Tiem", "120513"))
        // 6.1
        communeList.add(Commune(55, 6, "Sangkat Chak Angrae Leu", "120601"))
        communeList.add(Commune(56, 6, "Sangkat Chak Angrae Kraom", "120602"))
        communeList.add(Commune(57, 6, "Sangkat Stueng Mean Chey 1", "120603"))
        communeList.add(Commune(58, 6, "Sangkat Stueng Mean Chey 2", "120604"))
        communeList.add(Commune(59, 6, "Sangkat Stueng Mean Chey 3", "120605"))
        communeList.add(Commune(60, 6, "Sangkat Boeng Tumpun 1", "120606"))
        communeList.add(Commune(61, 6, "Sangkat Boeng Tumpun 2", "120607"))
        // 7.1
        communeList.add(Commune(62, 7, "Sangkat Svay Pak", "120701"))
        communeList.add(Commune(63, 7, "Sangkat Kilomaetr Lekh Prammouy", "120702"))
        communeList.add(Commune(64, 7, "Sangkat Ruessei Kaev", "120703"))
        communeList.add(Commune(65, 7, "Sangkat Chrang Chamreh 1", "120704"))
        communeList.add(Commune(66, 7, "Sangkat Chrang Chamreh 2", "120705"))
        communeList.add(Commune(67, 7, "Sangkat Tuol Sangkae 1", "120706"))
        communeList.add(Commune(68, 7, "Sangkat Tuol Sangkae 2", "120707"))
        // 8.1
        communeList.add(Commune(69, 8, "Sangkat Phnom Penh Thmei", "120801"))
        communeList.add(Commune(70, 8, "Sangkat Tuek Thla", "120802"))
        communeList.add(Commune(71, 8, "Sangkat Khmuonh", "120803"))
        communeList.add(Commune(72, 8, "Sangkat Krang Thnong", "120804"))
        communeList.add(Commune(73, 8, "Sangkat Ou Baek K'am", "120805"))
        communeList.add(Commune(74, 8, "Sangkat Kouk Khleang", "120806"))
        // 9.1
        communeList.add(Commune(75, 9, "Sangkat Samraong Kraom", "120901"))
        communeList.add(Commune(76, 9, "Sangkat Trapeang Krasang", "120902"))
        communeList.add(Commune(77, 9, "Sangkat Snaor", "120903"))
        communeList.add(Commune(78, 9, "Sangkat Ovlaok", "120904"))
        communeList.add(Commune(79, 9, "Sangkat Kamboul", "120905"))
        communeList.add(Commune(80, 9, "Sangkat Kantaok", "120906"))
        communeList.add(Commune(81, 9, "Sangkat Boeng Thum", "120907"))
        communeList.add(Commune(82, 9, "Sangkat Phleung Chheh Roteh", "120908"))
        communeList.add(Commune(83, 9, "Sangkat Chaom Chau 1", "120909"))
        communeList.add(Commune(84, 9, "Sangkat Chaom Chau 2", "120910"))
        communeList.add(Commune(85, 9, "Sangkat Chaom Chau 3", "120911"))
        communeList.add(Commune(86, 9, "Sangkat Kakab 1", "120912"))
        communeList.add(Commune(87, 9, "Sangkat Kakab 2", "120913"))
        // 10.1
        communeList.add(Commune(88, 10, "Sangkat Chrouy Changvar", "121001"))
        communeList.add(Commune(89, 10, "Sangkat Preaek Lieb", "121002"))
        communeList.add(Commune(90, 10, "Sangkat Preaek Ta Sek", "121003"))
        communeList.add(Commune(91, 10, "Sangkat Kaoh Dach", "121004"))
        communeList.add(Commune(92, 10, "Sangkat Bak Khaeng", "121005"))
        // 11.1
        communeList.add(Commune(93, 11, "Sangkat Preaek Pnov", "121101"))
        communeList.add(Commune(94, 11, "Sangkat Ponhea Pon", "121102"))
        communeList.add(Commune(95, 11, "Sangkat Samraong Kraom", "121103"))
        communeList.add(Commune(96, 11, "Sangkat Kouk Roka", "121104"))
        communeList.add(Commune(97, 11, "Sangkat Ponsang", "121105"))
        // 12.1
        communeList.add(Commune(98, 12, "Sangkat Chbar Ampov 1", "121201"))
        communeList.add(Commune(99, 12, "Sangkat Chbar Ampov 2", "121202"))
        communeList.add(Commune(100, 12, "Sangkat Nirouth", "121203"))
        communeList.add(Commune(101, 12, "Sangkat Preaek Pra", "121204"))
        communeList.add(Commune(102, 12, "Sangkat Veal Sbov", "121205"))
        communeList.add(Commune(103, 12, "Sangkat Preaek Aeng", "121206"))
        communeList.add(Commune(104, 12, "Sangkat Kbal Kaoh", "121207"))
        communeList.add(Commune(105, 12, "Sangkat Preaek thmei", "121208"))
        realm?.executeTransaction { realm ->
            realm.copyToRealmOrUpdate(communeList)
        }
    }

    private fun setupKhan() {
        khanList.clear()

        var khanId = ArrayList<Int>()
        val sangkat = realm!!.where(Khan::class.java).findAll()

        for (j in 0 until sangkat.size) {
            khanList.add(sangkat[j]?.name!!)
            khanId.add(sangkat[j]?.id!!)
        }
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("ជ្រើសរើសតំបន់របស់អ្មនក")
        builder.setItems(
            khanList.toTypedArray(),
            DialogInterface.OnClickListener { dialog, which ->
                txtkhan?.text = khanList[which]
                mBranchId = khanId[which]
                //    Log.d("CheckBranchId", mBranchId)
            })

        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    private fun setupsangkat() {

        sangkatList.clear()
        var code = ArrayList<String>()
        val sangkat = realm!!.where(Commune::class.java).equalTo("khanId", mBranchId).findAll()
        Log.d("khanID", mBranchId.toString())

        for (j in 0 until sangkat.size) {
            sangkatList.add(sangkat[j]?.name!!)
            code.add(sangkat[j]?.postcode!!)
        }
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("ជ្រើសរើសតំបន់របស់អ្មនក")
        builder.setItems(
            sangkatList.toTypedArray(),
            DialogInterface.OnClickListener { dialog, which ->
                if (sangkatList.isNotEmpty()) {
                    txtsangkat?.text = sangkatList[which]
                    Log.d("==>sangkat", sangkatList[which])
                    txtPostCode?.text = code[which]
                }


            })

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}