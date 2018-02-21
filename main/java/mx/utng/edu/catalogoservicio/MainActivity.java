package mx.utng.edu.catalogoservicio;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Servicio[] servicio = {
            new Servicio(R.drawable.spa1,"Masaje 1", "*Posee una cama simple o individual \n*Tiene un mobiliario básico\n*Posee cuarto de baño", "$550.00"),
            new Servicio(R.drawable.spa2, "Masaje 2","*Posee una cama matrimonial\n *Tiene mobiliario medio\n*Posee cuarto de baño mediano", "$1000.00"),
            new Servicio(R.drawable.spa3, "Masaje 3","*Posee dos camas individuales\n *Tiene mobiliario básico\n*Posee cuarto de baño", "$850.00"),
            new Servicio(R.drawable.spa4, "Masaje 4","Posee una cama King Size\n*Tiene modbiliario especial\n*Tiene sala de estar\n*Posee un cuarto de baño grande", "$1800.00")
    };
    private ListView lsvServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lista_servicio_layout);
        lsvServicio = findViewById(R.id.lsv_services);
        ServicioAdapter adapter = new ServicioAdapter(
                this,servicio);
        lsvServicio.setAdapter(adapter);

        lsvServicio.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    public class ViewHolder{
        TextView txvName;
        TextView txvDescripcion;
        TextView txvPrecio;
        ImageView imvPhoto;
    }

    class ServicioAdapter extends ArrayAdapter<Servicio> {
        public ServicioAdapter(@NonNull Context context, Servicio[] data){
            super(context, R.layout.catalogo_servicios_layout, data);
        }
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if (cell==null){
                LayoutInflater inflater =
                        LayoutInflater.from(getContext());
                cell = inflater.inflate(R.layout.catalogo_servicios_layout,null);
                holder = new ViewHolder();
                holder.imvPhoto = cell.findViewById(R.id.imv_photo);
                holder.txvName = cell.findViewById(R.id.txv_name);
                holder.txvDescripcion = cell.findViewById(R.id.txv_descripcion);
                holder.txvPrecio = cell.findViewById(R.id.txv_precio);
                cell.setTag(holder);
            }else{
                holder = (ViewHolder) cell.getTag();
            }
            holder.imvPhoto.setImageResource(servicio[position].getImageId());
            holder.txvName.setText(servicio[position].getName());
            holder.txvDescripcion.setText(servicio[position].getDescripción());
            holder.txvPrecio.setText(servicio[position].getPrecio());
            return cell;
        }
    }
}
