package com.diegovelez.petagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactoActivity extends AppCompatActivity implements View.OnClickListener {

    Session session = null;
    //ProgressDialog pdialog = null;
    Context context = null;
    EditText txtNombre, txtCorreo, txtMensaje;
    Button btnEnviar;
    String nombre, correo, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setLogo(R.drawable.huella);
        miActionBar.setTitle(R.string.app_name);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtNombre = (EditText) findViewById(R.id.txtNombreContacto);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        //ProgressDialog para que se visualice al usuario mientras se termina el proceso
        ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Enviando Email, por favor espere...");
        new RetreiveFeedTask(progress, this).execute();

        //captura de informacion digitada en el formulario
        nombre  = txtNombre.getText().toString();
        correo  = txtCorreo.getText().toString();
        mensaje = txtMensaje.getText().toString() + "<br> email de contacto: " + correo;

        //establece las propiedades para el acceso a la cuenta de correo a utilizar para el envio de emails
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");


        // Apertura de la sesion en cuenta de correo
        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("si.macrosystem@gmail.com", "@Max14396183");
            }
        });
    }


    class RetreiveFeedTask extends AsyncTask<String, Void, String> {
        ProgressDialog progress;
        ContactoActivity act;

        public RetreiveFeedTask(ProgressDialog progress, ContactoActivity act) {
            this.progress = progress;
            this.act = act;
        }

        @Override
        protected String doInBackground(String... params) {

            try{
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("si.macrosystem@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("xxxxxxxxxxxxxxxx"));
                message.setSubject("Petagram: "+nombre);
                message.setContent(mensaje, "text/html; charset=utf-8");
                Transport.send(message);
            } catch(MessagingException e) {
                e.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public void onPreExecute() {
            progress.show();
            //aquí se puede colocar código a ejecutarse previo
            //a la operación
        }

        @Override
        protected void onPostExecute(String result) {
            //pdialog.dismiss();
            txtNombre.setText("");
            txtCorreo.setText("");
            txtMensaje.setText("");
            progress.dismiss();
            Toast.makeText(getApplicationContext(), "Email Enviado", Toast.LENGTH_LONG).show();
        }
    }
}
