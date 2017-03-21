package br.com.ruavarejo.backend.pesquisa;

import org.springframework.core.convert.converter.Converter;

import br.com.ruavarejo.backend.annotation.WebComponent;

@WebComponent
public class PesquisaDTOToPesquisaConverter implements Converter<PesquisaDTO, Pesquisa>{

	@Override
	public Pesquisa convert(PesquisaDTO source) {
		Pesquisa pesquisa = new Pesquisa();
		pesquisa.setIp(source.getIp());
		pesquisa.setName(source.getName());
		pesquisa.setEmail(source.getEmail());
		pesquisa.setCompany(source.getCompany());
		pesquisa.setConheceVarejo(source.isConheceVarejo());
		pesquisa.setGrauImportancia(source.getGrauImportancia());
		pesquisa.setRapidezInformacao(source.getRapidezInformacao());
		pesquisa.setGiroEstoque(source.getGiroEstoque());
		pesquisa.setMetodologia(source.getMetodologia());
		pesquisa.setEmpresasConhecidas(source.getEmpresasConhecidas());
		pesquisa.setRelacaoVarejo(source.getRelacaoVarejo());
		pesquisa.setPossuiInteresse(source.getPossuiInteresse());
		return pesquisa;
	}

}
