package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.setContent;
import androidx.appcoompat.app.AppCompatActivity;
import androidx.compose.foundation.layout.fillMaxSize;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.Surface;
import androidx.compose.material3.Text;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.tooling.preview.Preview;
import com.example.myapplication..ui.theme.
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.picasso.Picasso;
import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.TracksPager;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.wallet.*;
import java.math.BigDecimal;
import java.util.*;
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myApplication {
                // A surface container using the "background" color from the theme
surface(
        modifier = Modifier,fillMaxSize(),
        color = MaterialTheme.colorScheme.background
        ) {
    Gretting("Android")
                 }
            }
        }
    }
}
        @Composable
fun Gretting(name: String, modifier: Modifier = Modifier ) {
    text(
            text = "Hello $name!",
        modifier = modifier
        )
}

@Preview(showBackground = true)
@Composable
fun GrettingPrevie() {
    MyApplicationTheme {
        Greeting("Android")
        }
}

class UploadActivity : AppCompatActivity() {
    private lateinit var mSelectBtn: Button
    private lateinit var mImageView: ImageView
    private lateinit var mProgressBar: PorgressBar

    private lateinit var mImageUri: Uri

    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        mSelectBtn = findViewById(R.id.select_btn)
        mImageView = findViewById(R.id.image_view)
        mProgressBar = findViewById(R.id.progress_bar)

        mSelectBtn.setOnClickListener(View.OnClickListener {
            openFileChooser()
        })
    }
    private fun openFileChooser() {
        vale intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent,PICK_IMAGE_REQUEST)
        }
override fun onActivityResult(requestCode: Int,resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode ==PICK_IMAGE_REQUEST && resultCode == RESULT_OK
        && data != null && data.data != null) {
        mImageUri = data.data!!
        Picasso.get().load(mImageUri).into(mImageView)
        }
    }
}

class InstagramActivity : AppCompatActivity() {

    private val CLIENT_ID ="your_client_id"
    private val CLIENT_SECRET = "your_client_secret"
    private val AUTHORIZATION_URL =  "https://api.instagram.com/oauth/authorize/"
    private val ACCESS_TOKEN_URL = "https://api.instagram.com/oauth/access_token"

    private lateinit var mWebView: WebView

    override fun onCreate(savedInstanceState: Bundel?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instagram)

        mWebView = finViewById(R.id.web_view)
        val authUrl =
        AUTHORIZATION_URL + "?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&
    }
}

// Se obtiene una instancia de la API de Spotify con de las credenciales de la aplicacion
val api = SpotifyApi().setAccessToken("TU_ACCESS_TOKEN"
// Se obtiene una instancia del servicio de Spotify para interactuar con la API
        val service = api.service

// Se realiza una búsqueda de una canción
        val tracks = service.searchTracks("nombre de la canción")
// Se crea una instancia del wrapper de SoundCloud con las credenciales de la aplicación
        val wrapper = SoundCloudWrapper("TU_CLIENT_ID", "TU_CLIENT_SECRET", "TU_USERNAME", "TU_PASSWORD")

// Se realiza una búsqueda de una canción
        val tracks = wrapper.searchTracks("nombre de la canción")
// Se crea una instancia del servicio de geocodificaciones de Google Maps
        val geoApi = GeoApiContext.Builder()
        .apiKey("TU_API_KEY")
        .build()

// Se realiza una búsqueda del lugar
        val results = GeocodingApi.geocode(geoApi, "dirección del lugar").await()

// Se obtiene la latitud y longitud del primer resultado
        val location = results[0].geometry.location
        val latitud = location.lat
        val longitud = location.lng
// Se crea un mapa de Google Maps
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->

        // Se añade un marcador en el lugar
        val marker = MarkerOptions()
        .position(LatLng(latitud, longitud))
        .title("Nombre del lugar")
        googleMap.addMarker(marker)
const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');

const app = express();

// Configurar body-parser para manejar solicitudes JSON
app.use(bodyParser.json());

// Conectar a la base de datos
mongoose.connect('mongodb://localhost:27017/myapp', { useNewUrlParser: true });

//Definir a la base de datos
mongoose.connect('mongodb://localhost:27017/myapp', { useNewUrlParser: true });

// Definir un esquema para la ropa
const clothingSchema = new mongoose.Schema( {
        name: String,
        price: Number,
        description: String,
        size: String,
        color: String,
        image: String
});

// Definir un modelo para la ropa
const Clothing = mongoose.model('Clothing', clothingSchema);

// Definir un modelo para subir ropa
app.post('/clothing', (req, res) => {
        const clothing = new Clothing({
        name:req.body.name,
        price:req.body.price,
        description:req.body.description,
        size:req.body.size
        color:req.body.color,
        image:req.body.image
        });
// Guardar el objeto en la base de datos
clothing.save((err) => {
  id (err) {
  console.log(err);
  res.sendStatus(500);
  } else {
  res.sendStatus(200);
       }
   });
});
// Iniciar el servidor en el puerto 3000
app.listen(3000, () => {
    console.log('Server started on port 3000');
        });
        dependencies {
        // ...
        implementation 'com.google.android.gms:play-services-wallet:20.1.0'
        implementation 'com.google.android.gms:play-services-identity:20.1.0'
        implementation 'com.google.android.gms:play-services-auth:20.1.0'
        }
<uses-permission android:name="android.permission.INTERNET" />
class GooglePayHelper(
        private val activity: Activity,
        private val price: BigDecimal,
        private val currencyCode: String
) {
        private lateinit var paymentsClient: PaymentsClient

        private val request = createPaymentDataRequest()

        private val environment = WalletConstans.ENVIRONMENT_TEST

        private val callback: PaymentMethodTokenizationParameters.PaymentMethodTokenizationParametersListener =
           object :
            PaymentMethodTokenizationParameters.PaymentMethodTokenizationParametersListener {
        override fun onResult(paymentMethodTokenizationParameters: PaymentMethodTokenizationParameters) {
            val paymentDataRequestJson = request.toJson()
            Log.d(TAG, "onResult: $paymentDataRequestJson")

            val request = IsReadyToPayRequest.fromJson(paymentDataRequestJson.toString())

            val readyToPayTask = paymentsClient.isReadyToPay(request)
            readyToPayTask.addOnCompleteListener { task ->
                try {
                    val result = task.getResult(ApiException::class.java)
                    if (result!!) {
                        // Show Google as payment option
                        Log.d(TAG, "Ready to pay")
                        // Do the rest of the checkout flow
                        requestPayment(paymentMethodTokenizationParameters)
                    } else {
                        // Hide Google as payment option
                        Log.d(TAG, "Not ready to pay")
                    }
                } catch (exception: ApiException) {
                    Log.e(TAG, "Exception checking if Google Pay is available", exception)
                }
            }
        }
        override fun onError(statusCode: Int) {
            Log.e(TAG, "Error getting tokenization parameters. Status code: $statusCode")
        }
    }

    private fun createPaymentDataRequest(): PaymentDataRequest {
        val paramsBuilder = PaymentMethodTokenizationParameters.newBuilder()
                .setPaymentMethodTokenizationType(
                        PaymentMethodTokenizationType.PAYMENT_GATEWAY
                )
                .addParameter("gateway", "example")
                .addParameter("gatewayMerchantId", "exampleMerchantId")

        val paymentDataRequestJson = "{\n" +
                "  \"apiVersion\": 2,\n" +
                "  \"apiVersionMinor\": 0,\n" +
                "  \"allowedPaymentMethods\": [{\n" +
                "    \"type\": \"CARD\",\n" +
                "    \"parameters\": {\n" +
                "      \"allowedAuthMethods\": [\"PAN_ONLY\", \"CRYPTOGRAM_3DS\"],\n" +
                "      \"allowedCardNetworks\": [\"AMEX\", \"DISCOVER\", \"JCB\", \"MASTERCARD\", \"VISA\"],\n" +
                "      \"billingAddressRequired\": true,\n

}
}

