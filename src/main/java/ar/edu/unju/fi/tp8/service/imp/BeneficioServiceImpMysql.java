package ar.edu.unju.fi.tp8.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Beneficio;
import ar.edu.unju.fi.tp8.model.Cliente;
import ar.edu.unju.fi.tp8.repository.IBeneficioRepository;
import ar.edu.unju.fi.tp8.service.IBeneficioService;

@Service("")
public class BeneficioServiceImpMysql implements IBeneficioService{

	@Autowired
	private IBeneficioRepository beneficioRepository;
	
	
	
	@Override
	public void generarBeneficios() {
		// TODO Auto-generated method stub
		
		List<Beneficio> beneficios = (List<Beneficio>) beneficioRepository.findAll();
		
		if(beneficios.isEmpty()) {
			Beneficio beneficio = new Beneficio();
			Beneficio beneficio1 = new Beneficio();
			Beneficio beneficio2 = new Beneficio();
			Beneficio beneficio3 = new Beneficio();
			
			beneficio.setDescripcion("10% descuento para jubilados");
			beneficioRepository.save(beneficio);
			beneficio1.setDescripcion("15% descuento cliente Bco. Macro");
			beneficioRepository.save(beneficio1);
			beneficio2.setDescripcion("3 cuotas sin intereses");
			beneficioRepository.save(beneficio2);
			beneficio3.setDescripcion("6 cuotas sin intereses");
			beneficioRepository.save(beneficio3);
			
			
		}

	}
	
	@Override
	public Beneficio encontrarBeneficio(long id) {
		// TODO Auto-generated method stub
		return beneficioRepository.findById(id).orElse(null);
	
	}



	@Override
	public List<Beneficio> obtenerBeneficios() {
		// TODO Auto-generated method stub
		List<Beneficio> beneficios= (List<Beneficio>) beneficioRepository.findAll();
		
		return beneficios;
	}

}
