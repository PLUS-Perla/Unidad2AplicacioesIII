package mx.utng.edu.catalogorestaurantes;

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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Restaurantes[] restaurantes = {
            new Restaurantes(R.drawable.restaurant1,"Restaurantes 1", "*Postres y comidas \n*Bonito lugar\n*Servicio amable", "$550.00"),
            new Restaurantes(R.drawable.restaurant2,"Restaurantes 1", "*Postres y comidas \n*Bonito lugar\n*Servicio amable", "$550.00"),
            new Restaurantes(R.drawable.restaurant3,"Restaurantes 1", "*Postres y comidas \n*Bonito lugar\n*Servicio amable", "$550.00"),
            new Restaurantes(R.drawable.restaurant4,"Restaurantes 1", "*Postres y comidas \n*Bonito lugar\n*Servicio amable", "$550.00"), };
    private ListView lsvRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_restaurant_layout);
        lsvRestaurante = findViewById(R.id.lsv_restaurantes);
        RestauranteAdapter adapter = new RestauranteAdapter(
                this,restaurantes);
        lsvRestaurante.setAdapter(adapter);

        lsvRestaurante.setOnItemClickListener(this);
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

    class RestauranteAdapter extends ArrayAdapter<Restaurantes> {
        public RestauranteAdapter(@NonNull Context context, Restaurantes[] data){
            super(context, R.layout.catalogo_restaurant_layout, data);
        }
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if (cell==null){
                LayoutInflater inflater =
                        LayoutInflater.from(getContext());
                cell = inflater.inflate(R.layout.catalogo_restaurant_layout,null);
                holder = new ViewHolder();
                holder.imvPhoto = cell.findViewById(R.id.imv_photo);
                holder.txvName = cell.findViewById(R.id.txv_name);
                holder.txvDescripcion = cell.findViewById(R.id.txv_descripcion);
                holder.txvPrecio = cell.findViewById(R.id.txv_precio);
                cell.setTag(holder);
            }else{
                holder = (ViewHolder) cell.getTag();
            }
            holder.imvPhoto.setImageResource(restaurantes[position].getImageId());
            holder.txvName.setText(restaurantes[position].getName());
            holder.txvDescripcion.setText(restaurantes[position].getDescripción());
            holder.txvPrecio.setText(restaurantes[position].getPrecio());
            return cell;
        }
    }
}

