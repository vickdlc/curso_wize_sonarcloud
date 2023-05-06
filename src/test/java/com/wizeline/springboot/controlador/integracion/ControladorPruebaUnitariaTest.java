package com.wizeline.springboot.controlador.integracion;

import com.wizeline.springboot.controlador.ControladorPais;
import com.wizeline.springboot.otd.OTDPais;
import com.wizeline.springboot.servicio.ServicioPais;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ControladorPruebaUnitariaTest {

    @Mock
    private ServicioPais servicioPais;

    @InjectMocks
    private ControladorPais controladorPais;

    @Test
    public void DadoServicioPaisEntrega_CuandoObtieneElPaise_EntoncesCreaUnPais() {
        OTDPais otdPais = new OTDPais("Argentina", 23323);
        when(servicioPais.crearPais(1L,"Argentina", 23323)).thenReturn(new OTDPais("Argentina", 23323));

        final ResponseEntity<OTDPais> responseEntity = controladorPais.crearPais("Argentina", 23323, 1L);

        assertAll(
                () -> assertNotNull(responseEntity),
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertEquals(otdPais, responseEntity.getBody())
        );
    }

    @Test
    public void DadoServicioPaisEntrega_CuandoObtieneElPaise_EntoncesActualizaUnPais() {
        OTDPais otdPais = new OTDPais("Argentina", 23323);
        when(servicioPais.actualizarPais(1L,"Argentina", 23323)).thenReturn("ok");

        final ResponseEntity<String> responseEntity = controladorPais.actualizarPais("Argentina", 23323, 1L);

        assertAll(
                () -> assertNotNull(responseEntity),
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertEquals("actualizado", responseEntity.getBody())
        );
    }

    @Test
    public void DadoServicioPaisEntrega_CuandoObtieneElIdPais_EntonceseliminaUnPais() {
        OTDPais otdPais = new OTDPais("Argentina", 23323);
        when(servicioPais.deletePais(1L)).thenReturn("ok");

        final ResponseEntity<String> responseEntity = controladorPais.deletePais(1L);

        assertAll(
                () -> assertNotNull(responseEntity),
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertEquals("eliminado", responseEntity.getBody())
        );
    }
}
