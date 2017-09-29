package com.aquino.servicedesk.activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aquino.servicedesk.R;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Setear Toolbar como action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, android.R.string.ok, android.R.string.cancel);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set NavigationItemSelectedListener
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // Do action by menu item id
                switch (menuItem.getItemId()){
                    case R.id.nav_registrar:
                        Toast.makeText(HomeActivity.this, "Registrar ticket nuevo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_consultarEstado:
                        Toast.makeText(HomeActivity.this, "Consultar estado de ticket", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_consultarTickets:
                        Toast.makeText(HomeActivity.this, "Consultando tickets", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_asignar:
                        Toast.makeText(HomeActivity.this, "Asignando tickets", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_asignados:
                        Toast.makeText(HomeActivity.this, "Tickets asignados", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_atender:
                        Toast.makeText(HomeActivity.this, "Atender tickets", Toast.LENGTH_SHORT).show();
                        break;
                }

                // Close drawer
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

        Intent intent= getIntent();
        String nombre = intent.getStringExtra("nombre");
        int rol = Integer.parseInt(intent.getStringExtra("rol"));

        // Change navigation header information
        ImageView photoImage = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.menu_photo);
        photoImage.setBackgroundResource(R.drawable.ic_profile);

        TextView fullnameText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_fullname);
        fullnameText.setText(nombre);

        TextView emailText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_email);



        switch (rol){
            case 1 :
                navigationView.getMenu().findItem(R.id.nav_registrar).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_consultarEstado).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_consultarTickets).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_asignar).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_asignados).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_atender).setVisible(false);
                emailText.setText("Cliente");
                break;
            case 2 :
                navigationView.getMenu().findItem(R.id.nav_registrar).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_consultarEstado).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_consultarTickets).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_asignar).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_asignados).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_atender).setVisible(false);
                emailText.setText("Supervisor");
                break;
            case 3 :
                navigationView.getMenu().findItem(R.id.nav_registrar).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_consultarEstado).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_consultarTickets).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_asignar).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_asignados).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_atender).setVisible(true);
                emailText.setText("Técnico");
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_perfil:
                Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_configuracion:
                Toast.makeText(this, "Configuracion", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_cerrarsesion:
                Intent intent= new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
        }
            switch (item.getItemId()) {
                case android.R.id.home: // Option open drawer
                    if(!drawerLayout.isDrawerOpen(GravityCompat.START))
                        drawerLayout.openDrawer(GravityCompat.START);   // Open drawer
                    else
                        drawerLayout.closeDrawer(GravityCompat.START);    // Close drawer
                    return true;
            }



        return super.onOptionsItemSelected(item);
    }

}



