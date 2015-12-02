package br.com.cnf.curso.inscricao.cadastro.validacao;

import br.com.cnf.curso.inscricao.Constantes;
import br.com.cnf.curso.inscricao.model.CursoInscricao;
import br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj;
import br.com.cnf.curso.inscricao.model.CursoInscricaoCpf;
import br.com.cnf.curso.inscricao.model.CursoParticipante;
import br.com.cnf.curso.inscricao.util.Helper;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

public class Validacao {

	public static boolean validarEtapa01(String cpfCnpj,
			String tipoFisicaJuridica, List<String> errors) {

		boolean valid = true;

		// Validar pessoa física
		if ((tipoFisicaJuridica.equals(Constantes.PESSOA_FISICA))
				&& (Validator.isNull(cpfCnpj))) {
			errors.add("mensagem.erro.cpf.obrigatorio");
			valid = false;
		} else if ((tipoFisicaJuridica.equals(Constantes.PESSOA_FISICA))
				&& (Validator.isNotNull(cpfCnpj))
				&& (!Helper.isCPF(GetterUtil.getLong(Helper
						.retirarSinais(cpfCnpj))))) {
			errors.add("mensagem.erro.cpf.invalido");
			valid = false;
		}

		// Validar pessoa jurídica
		if ((tipoFisicaJuridica.equals(Constantes.PESSOA_JURIDICA))
				&& (Validator.isNull(cpfCnpj))) {
			errors.add("mensagem.erro.cnpj.obrigatorio");
			valid = false;
		} else if ((tipoFisicaJuridica.equals(Constantes.PESSOA_JURIDICA))
				&& (Validator.isNotNull(cpfCnpj))
				&& (!Helper.isCNPJ(GetterUtil.getLong(Helper
						.retirarSinais(cpfCnpj))))) {
			errors.add("mensagem.erro.cnpj.invalido");
			valid = false;
		}

		return valid;
	}

	public static boolean validarEtapa02(CursoInscricao cursoInscricao,
			List<String> errors) {

		boolean valid = true;

		// Validar nome
		if (Validator.isNull(cursoInscricao.getNomeResponsavel())) {
			errors.add("mensagem.erro.nomeResponsavelInscricao.obrigatorio");
			valid = false;
		} else if (!Helper.nomeValido(cursoInscricao.getNomeResponsavel())) {
			errors.add("mensagem.erro.nomeResponsavelInscricao.minimoDoisNomes");
			valid = false;
		}
		// Validar email principal
		if (Validator.isNull(cursoInscricao.getEmailPrincipal())) {
			errors.add("mensagem.erro.emailPrincipal.obrigatorio");
			valid = false;
		} else if (!Helper.isEmail(cursoInscricao.getEmailPrincipal())) {
			errors.add("mensagem.erro.emailPrincipal.invalido");
			valid = false;
		}
		// Validar ddd telefone comercial
		if (Validator.isNull(cursoInscricao.getDddTelefoneComercial())) {
			errors.add("mensagem.erro.dddTelefoneComercial.obrigatorio");
			valid = false;
		}
		// Validar telefone comercial
		if (Validator.isNull(cursoInscricao.getTelefoneComercial())) {
			errors.add("mensagem.erro.telefoneComercial.obrigatorio");
			valid = false;
		}

		return valid;
	}

	public static boolean validarEtapa03CPF(
			CursoParticipante cursoParticipante, List<String> errors) {

		boolean valid = true;

		// Validar nome
		if (Validator.isNull(cursoParticipante.getNomeCompleto())) {
			errors.add("mensagem.erro.nomeCompletoobrigatorio");
			valid = false;
		}
		/*
		// Validar crachá
		if (Validator.isNull(cursoParticipante.getNomeCracha())) {
			errors.add("mensagem.erro.nomeCracha.obrigatorio");
			valid = false;
		}
		*/
		// Validar cpf
		if (Validator.isNull(cursoParticipante.getCpf())) {
			errors.add("mensagem.erro.cpf.obrigatorio");
			valid = false;
		} else if ((Validator.isNotNull(cursoParticipante.getCpf()))
				&& (!Helper.isCPF(GetterUtil.getLong(Helper
						.retirarSinais(cursoParticipante.getCpf()))))) {
			errors.add("mensagem.erro.cpf.invalido");
			valid = false;
		}
		// Validar email principal
		if (Validator.isNull(cursoParticipante.getEmailPrincipal())) {
			errors.add("mensagem.erro.emailPrincipal.obrigatorio");
			valid = false;
		} else if (!Helper.isEmail(cursoParticipante.getEmailPrincipal())) {
			errors.add("mensagem.erro.emailPrincipal.invalido");
			valid = false;
		}
		// Validar ddd telefone comercial
		if (Validator.isNull(cursoParticipante.getDddTelefoneComercial())) {
			errors.add("mensagem.erro.dddTelefoneComercial.obrigatorio");
			valid = false;
		}
		// Validar telefone comercial
		if (Validator.isNull(cursoParticipante.getTelefoneComercial())) {
			errors.add("mensagem.erro.telefoneComercial.obrigatorio");
			valid = false;
		}
		// Validar endereço
		if (Validator.isNull(cursoParticipante.getEndereco())) {
			errors.add("mensagem.erro.endereco.obrigatorio");
			valid = false;
		}
		// Validar bairro
		if (Validator.isNull(cursoParticipante.getBairro())) {
			errors.add("mensagem.erro.bairro.obrigatorio");
			valid = false;
		}
		// Validar cidade
		if (Validator.isNull(cursoParticipante.getCidade())) {
			errors.add("mensagem.erro.cidade.obrigatorio");
			valid = false;
		}
		// Validar estado
		if (Validator.isNull(cursoParticipante.getEstado())) {
			errors.add("mensagem.erro.estado.obrigatorio");
			valid = false;
		}
		// Validar CEP
		if (Validator.isNull(cursoParticipante.getCep())) {
			errors.add("mensagem.erro.cep.obrigatorio");
			valid = false;
		}

		return valid;
	}

	public static boolean validarEtapa04CPF(
			CursoInscricaoCpf cursoInscricaoCpf, List<String> errors) {

		boolean valid = true;

		// Validar nome
		if (Validator.isNull(cursoInscricaoCpf.getNome())) {
			errors.add("mensagem.erro.nome.obrigatorio");
			valid = false;
		}
		// Validar cpf
		if (Validator.isNull(cursoInscricaoCpf.getCpf())) {
			errors.add("mensagem.erro.cpf.obrigatorio");
			valid = false;
		} else if ((Validator.isNotNull(cursoInscricaoCpf.getCpf()))
				&& (!Helper.isCPF(GetterUtil.getLong(Helper
						.retirarSinais(cursoInscricaoCpf.getCpf()))))) {
			errors.add("mensagem.erro.cpf.invalido");
			valid = false;
		}
		// Validar endereço
		if (Validator.isNull(cursoInscricaoCpf.getEndereco())) {
			errors.add("mensagem.erro.endereco.obrigatorio");
			valid = false;
		}
		// Validar bairro
		if (Validator.isNull(cursoInscricaoCpf.getBairro())) {
			errors.add("mensagem.erro.bairro.obrigatorio");
			valid = false;
		}
		// Validar cidade
		if (Validator.isNull(cursoInscricaoCpf.getCidade())) {
			errors.add("mensagem.erro.cidade.obrigatorio");
			valid = false;
		}
		// Validar estado
		if (Validator.isNull(cursoInscricaoCpf.getEstado())) {
			errors.add("mensagem.erro.estado.obrigatorio");
			valid = false;
		}
		// Validar CEP
		if (Validator.isNull(cursoInscricaoCpf.getCep())) {
			errors.add("mensagem.erro.cep.obrigatorio");
			valid = false;
		}
		// Validar ddd telefone
		if (Validator.isNull(cursoInscricaoCpf.getDddTelefone())) {
			errors.add("mensagem.erro.dddTelefone.obrigatorio");
			valid = false;
		}
		// Validar telefone
		if (Validator.isNull(cursoInscricaoCpf.getTelefone())) {
			errors.add("mensagem.erro.telefone.obrigatorio");
			valid = false;
		}
		// Validar email
		if (Validator.isNull(cursoInscricaoCpf.getEmail())) {
			errors.add("mensagem.erro.email.obrigatorio");
			valid = false;
		} else if (!Helper.isEmail(cursoInscricaoCpf.getEmail())) {
			errors.add("mensagem.erro.email.invalido");
			valid = false;
		}

		return valid;
	}

	public static boolean validarEtapa03CNPJ(
			CursoInscricaoCnpj cursoInscricaoCnpj, List<String> errors) {

		boolean valid = true;

		// Validar razão social
		if (Validator.isNull(cursoInscricaoCnpj.getRazaoSocial())) {
			errors.add("mensagem.erro.razaoSocial.obrigatorio");
			valid = false;
		}
		// Validar nome fantasia
		if (Validator.isNull(cursoInscricaoCnpj.getNomeFantasia())) {
			errors.add("mensagem.erro.nomeFantasia.obrigatorio");
			valid = false;
		}

		// Validar Inscrição estadual
		if (Validator.isNull(cursoInscricaoCnpj.getInscricaoEstadual())) {
			errors.add("mensagem.erro.inscricaoEstadual.obrigatorio");
			valid = false;
		}
		// Validar endereço
		if (Validator.isNull(cursoInscricaoCnpj.getEndereco())) {
			errors.add("mensagem.erro.endereco.obrigatorio");
			valid = false;
		}
		// Validar bairro
		if (Validator.isNull(cursoInscricaoCnpj.getBairro())) {
			errors.add("mensagem.erro.bairro.obrigatorio");
			valid = false;
		}
		// Validar cidade
		if (Validator.isNull(cursoInscricaoCnpj.getCidade())) {
			errors.add("mensagem.erro.cidade.obrigatorio");
			valid = false;
		}
		// Validar estado
		if (Validator.isNull(cursoInscricaoCnpj.getEstado())) {
			errors.add("mensagem.erro.estado.obrigatorio");
			valid = false;
		}
		// Validar CEP
		if (Validator.isNull(cursoInscricaoCnpj.getCep())) {
			errors.add("mensagem.erro.cep.obrigatorio");
			valid = false;
		}

		// Validar nome
		if (Validator.isNull(cursoInscricaoCnpj.getNfNome())) {
			errors.add("mensagem.erro.nomeNf.obrigatorio");
			valid = false;
		}
		// Validar departamento
		if (Validator.isNull(cursoInscricaoCnpj.getNfDepartamento())) {
			errors.add("mensagem.erro.departamentoNf.obrigatorio");
			valid = false;
		}
		// Validar email
		if (Validator.isNull(cursoInscricaoCnpj.getNfEmail())) {
			errors.add("mensagem.erro.emailNf.obrigatorio");
			valid = false;
		} else if (!Helper.isEmail(cursoInscricaoCnpj.getNfEmail())) {
			errors.add("mensagem.erro.emailNf.invalido");
			valid = false;
		}
		// Validar ddd telefone
		if (Validator.isNull(cursoInscricaoCnpj.getNfDddTelefone())) {
			errors.add("mensagem.erro.dddTelefoneNf.obrigatorio");
			valid = false;
		}
		// Validar telefone
		if (Validator.isNull(cursoInscricaoCnpj.getNfTelefone())) {
			errors.add("mensagem.erro.telefoneNf.obrigatorio");
			valid = false;
		}

		return valid;
	}

	public static boolean validarEtapa04CNPJ(
			CursoParticipante cursoParticipante, List<String> errors) {

		boolean valid = true;

		// Validar nome
		if (Validator.isNull(cursoParticipante.getNomeCompleto())) {
			errors.add("mensagem.erro.nomeCompleto.obrigatorio");
			valid = false;
		}
		/*
		// Validar crachá
		if (Validator.isNull(cursoParticipante.getNomeCracha())) {
			errors.add("mensagem.erro.nomeCracha.obrigatorio");
			valid = false;
		}
		*/
		// Validar cpf
		if (Validator.isNull(cursoParticipante.getCpf())) {
			errors.add("mensagem.erro.cpf.obrigatorio");
			valid = false;
		} else if ((Validator.isNotNull(cursoParticipante.getCpf()))
				&& (!Helper.isCPF(GetterUtil.getLong(Helper
						.retirarSinais(cursoParticipante.getCpf()))))) {
			errors.add("mensagem.erro.cpf.invalido");
			valid = false;
		}
		// Validar cargo
		if (Validator.isNull(cursoParticipante.getCargo())) {
			errors.add("mensagem.erro.cargo.obrigatorio");
			valid = false;
		}
		// Validar departamento
		if (Validator.isNull(cursoParticipante.getDepartamento())) {
			errors.add("mensagem.erro.departamento.obrigatorio");
			valid = false;
		}
		// Validar email principal
		if (Validator.isNull(cursoParticipante.getEmailPrincipal())) {
			errors.add("mensagem.erro.emailPrincipal.obrigatorio");
			valid = false;
		} else if (!Helper.isEmail(cursoParticipante.getEmailPrincipal())) {
			errors.add("mensagem.erro.emailPrincipal.invalido");
			valid = false;
		}
		// Validar ddd telefone comercial
		if (Validator.isNull(cursoParticipante.getDddTelefoneComercial())) {
			errors.add("mensagem.erro.dddTelefoneComercial.obrigatorio");
			valid = false;
		}
		// Validar telefone comercial
		if (Validator.isNull(cursoParticipante.getTelefoneComercial())) {
			errors.add("mensagem.erro.telefoneComercial.obrigatorio");
			valid = false;
		}

		// Validar endereço
		if (Validator.isNull(cursoParticipante.getEndereco())) {
			errors.add("mensagem.erro.endereco.obrigatorio");
			valid = false;
		}
		// Validar bairro
		if (Validator.isNull(cursoParticipante.getBairro())) {
			errors.add("mensagem.erro.bairro.obrigatorio");
			valid = false;
		}
		// Validar cidade
		if (Validator.isNull(cursoParticipante.getCidade())) {
			errors.add("mensagem.erro.cidade.obrigatorio");
			valid = false;
		}
		// Validar estado
		if (Validator.isNull(cursoParticipante.getEstado())) {
			errors.add("mensagem.erro.estado.obrigatorio");
			valid = false;
		}
		// Validar CEP
		if (Validator.isNull(cursoParticipante.getCep())) {
			errors.add("mensagem.erro.cep.obrigatorio");
			valid = false;
		}

		return valid;
	}

	public static boolean validarEtapaFormaPagamento(
			CursoInscricao cursoInscricao, List<String> errors) {

		boolean valid = true;

		// Forma de pagamento
		if (Validator.isNull(cursoInscricao.getFormaPagamento())) {
			errors.add("mensagem.erro.formaPagamento.obrigatoria");
			valid = false;
		} else {
			// Quantidade de parcelas
			if (cursoInscricao.getQuantidadeParcelas() == 0) {
				errors.add("mensagem.erro.qtdeParcelas.obrigatoria");
				valid = false;
			}
			if ( (!Constantes.ITAU_BOLETO.equals(cursoInscricao.getFormaPagamento())) && (!Constantes.CREDITO_CONTA.equals(cursoInscricao.getFormaPagamento())) ) {
				// Validar número do cartão
				if (Validator.isNull(cursoInscricao.getNumeroCartao())) {
					errors.add("mensagem.erro.numeroCartao.obrigatorio");
					valid = false;
				} else if (!Helper.isInteger(cursoInscricao.getNumeroCartao())) {
					errors.add("mensagem.erro.numeroCartao.temQueSerNumerico");
					valid = false;
				}
				// Validar mês do cartão
				if (Validator.isNull(cursoInscricao.getValidadeCartaoMes())) {
					errors.add("mensagem.erro.cartaoValidadeMes.obrigatorio");
					valid = false;
				} else if (cursoInscricao.getValidadeCartaoMes() == 0) {
					errors.add("mensagem.erro.cartaoValidadeMes.temQueSerNumerico");
					valid = false;
				} else if (!Helper.isInteger(cursoInscricao.getValidadeCartaoMes())) {
					errors.add("mensagem.erro.cartaoValidadeMes.temQueSerNumerico");
					valid = false;
				}
				// Validar mês do cartão
				if (Validator.isNull(cursoInscricao.getValidadeCartaoAno())) {
					errors.add("mensagem.erro.cartaoValidadeAno.obrigatorio");
					valid = false;
				} else if (cursoInscricao.getValidadeCartaoAno() == 0) {
					errors.add("mensagem.erro.cartaoValidadeAno.temQueSerNumerico");
					valid = false;
				} else if (!Helper.isInteger(cursoInscricao.getValidadeCartaoAno())) {
					errors.add("mensagem.erro.cartaoValidadeAno.temQueSerNumerico");
					valid = false;
				}
				// Validar nome titular do cartão
				if (Validator.isNull(cursoInscricao.getNomeTitularCartao())) {
					errors.add("mensagem.erro.nomeTitularCartao.obrigatorio");
					valid = false;
				}
				// Validar código de segurança do cartão
				if (Validator.isNull(cursoInscricao.getCodigoSegurancaCartao())) {
					errors.add("mensagem.erro.cartaoCodigoSeguranca.obrigatorio");
					valid = false;
				} else if (!Helper.isInteger(cursoInscricao.getCodigoSegurancaCartao())) {
					errors.add("mensagem.erro.cartaoCodigoSeguranca.temQueSerNumerico");
					valid = false;
				}
			}
		}
		return valid;
	}
}
