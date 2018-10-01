package code.maribelhll.tareasemana5_basedatos;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.view.View.OnClickListener;
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


public class FormularioMascotas extends AppCompatActivity implements OnClickListener {

    EditText asunto=null;
    EditText correo=null;
    EditText mensaje= null;
    Button enviar= null;

    Context context;
    Session session;
    ProgressDialog progressDialog;

    String titulo;
    String email;
    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_mascotas);

        context= this;

        correo = (EditText) findViewById(R.id.etxtCorreo);
        mensaje = (EditText) findViewById(R.id.etxtMensaje);
        asunto = (EditText) findViewById(R.id.etxtNombre);
        enviar = (Button) findViewById(R.id.btnEnviarComentario);

        enviar.setOnClickListener(FormularioMascotas.this);
    }

    @Override
    public void onClick(View v) {
        email = correo.getText().toString();
        texto = mensaje.getText().toString();
        titulo = asunto.getText().toString();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1pruebasmh@gmail.com", "pruebas123");
            }
        });

        progressDialog = ProgressDialog.show(context, "", "Sending Mail...", true);

        SendMail sendMail = new SendMail();
        sendMail.execute();
    }

    class SendMail extends AsyncTask<String,Void, String>{

        @Override
        protected String doInBackground(String... strings) {

            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("1pruebasmh@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                message.setSubject(titulo);
                message.setContent(texto, "text/html; charset=utf-8");
                Transport.send(message);
            } catch(MessagingException e) {
                e.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            correo.setText("");
            mensaje.setText("");
            Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_LONG).show();
        }
    }


}
