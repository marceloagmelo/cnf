/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package br.com.cnf.curso.inscricao.model;

import br.com.cnf.curso.inscricao.service.ClpSerializer;
import br.com.cnf.curso.inscricao.service.CursoInscricaoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SEA
 */
public class CursoInscricaoClp extends BaseModelImpl<CursoInscricao>
	implements CursoInscricao {
	public CursoInscricaoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CursoInscricao.class;
	}

	@Override
	public String getModelClassName() {
		return CursoInscricao.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _inscricaoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInscricaoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _inscricaoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inscricaoId", getInscricaoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userCreateId", getUserCreateId());
		attributes.put("userCreateName", getUserCreateName());
		attributes.put("userModifiedId", getUserModifiedId());
		attributes.put("userModifiedName", getUserModifiedName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("cursoId", getCursoId());
		attributes.put("cursoNome", getCursoNome());
		attributes.put("cursoData", getCursoData());
		attributes.put("cursoHorario", getCursoHorario());
		attributes.put("cursoLocal", getCursoLocal());
		attributes.put("preco", getPreco());
		attributes.put("precoConvenio", getPrecoConvenio());
		attributes.put("precoAssociado", getPrecoAssociado());
		attributes.put("tipoFisicaJuridica", getTipoFisicaJuridica());
		attributes.put("cpfCnpj", getCpfCnpj());
		attributes.put("nomeResponsavel", getNomeResponsavel());
		attributes.put("emailPrincipal", getEmailPrincipal());
		attributes.put("dddTelefoneComercial", getDddTelefoneComercial());
		attributes.put("telefoneComercial", getTelefoneComercial());
		attributes.put("sexo", getSexo());
		attributes.put("cadastroFinalizado", getCadastroFinalizado());
		attributes.put("formaPagamento", getFormaPagamento());
		attributes.put("numeroCartao", getNumeroCartao());
		attributes.put("validadeCartaoMes", getValidadeCartaoMes());
		attributes.put("validadeCartaoAno", getValidadeCartaoAno());
		attributes.put("nomeTitularCartao", getNomeTitularCartao());
		attributes.put("codigoSegurancaCartao", getCodigoSegurancaCartao());
		attributes.put("statusMoedaDigital", getStatusMoedaDigital());
		attributes.put("quantidadeParcelas", getQuantidadeParcelas());
		attributes.put("valorTotal", getValorTotal());
		attributes.put("moedaDigitalPedido", getMoedaDigitalPedido());
		attributes.put("dataInicio", getDataInicio());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long inscricaoId = (Long)attributes.get("inscricaoId");

		if (inscricaoId != null) {
			setInscricaoId(inscricaoId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userCreateId = (Long)attributes.get("userCreateId");

		if (userCreateId != null) {
			setUserCreateId(userCreateId);
		}

		String userCreateName = (String)attributes.get("userCreateName");

		if (userCreateName != null) {
			setUserCreateName(userCreateName);
		}

		Long userModifiedId = (Long)attributes.get("userModifiedId");

		if (userModifiedId != null) {
			setUserModifiedId(userModifiedId);
		}

		String userModifiedName = (String)attributes.get("userModifiedName");

		if (userModifiedName != null) {
			setUserModifiedName(userModifiedName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long cursoId = (Long)attributes.get("cursoId");

		if (cursoId != null) {
			setCursoId(cursoId);
		}

		String cursoNome = (String)attributes.get("cursoNome");

		if (cursoNome != null) {
			setCursoNome(cursoNome);
		}

		String cursoData = (String)attributes.get("cursoData");

		if (cursoData != null) {
			setCursoData(cursoData);
		}

		String cursoHorario = (String)attributes.get("cursoHorario");

		if (cursoHorario != null) {
			setCursoHorario(cursoHorario);
		}

		String cursoLocal = (String)attributes.get("cursoLocal");

		if (cursoLocal != null) {
			setCursoLocal(cursoLocal);
		}

		String preco = (String)attributes.get("preco");

		if (preco != null) {
			setPreco(preco);
		}

		String precoConvenio = (String)attributes.get("precoConvenio");

		if (precoConvenio != null) {
			setPrecoConvenio(precoConvenio);
		}

		String precoAssociado = (String)attributes.get("precoAssociado");

		if (precoAssociado != null) {
			setPrecoAssociado(precoAssociado);
		}

		String tipoFisicaJuridica = (String)attributes.get("tipoFisicaJuridica");

		if (tipoFisicaJuridica != null) {
			setTipoFisicaJuridica(tipoFisicaJuridica);
		}

		String cpfCnpj = (String)attributes.get("cpfCnpj");

		if (cpfCnpj != null) {
			setCpfCnpj(cpfCnpj);
		}

		String nomeResponsavel = (String)attributes.get("nomeResponsavel");

		if (nomeResponsavel != null) {
			setNomeResponsavel(nomeResponsavel);
		}

		String emailPrincipal = (String)attributes.get("emailPrincipal");

		if (emailPrincipal != null) {
			setEmailPrincipal(emailPrincipal);
		}

		String dddTelefoneComercial = (String)attributes.get(
				"dddTelefoneComercial");

		if (dddTelefoneComercial != null) {
			setDddTelefoneComercial(dddTelefoneComercial);
		}

		String telefoneComercial = (String)attributes.get("telefoneComercial");

		if (telefoneComercial != null) {
			setTelefoneComercial(telefoneComercial);
		}

		String sexo = (String)attributes.get("sexo");

		if (sexo != null) {
			setSexo(sexo);
		}

		Boolean cadastroFinalizado = (Boolean)attributes.get(
				"cadastroFinalizado");

		if (cadastroFinalizado != null) {
			setCadastroFinalizado(cadastroFinalizado);
		}

		String formaPagamento = (String)attributes.get("formaPagamento");

		if (formaPagamento != null) {
			setFormaPagamento(formaPagamento);
		}

		String numeroCartao = (String)attributes.get("numeroCartao");

		if (numeroCartao != null) {
			setNumeroCartao(numeroCartao);
		}

		Integer validadeCartaoMes = (Integer)attributes.get("validadeCartaoMes");

		if (validadeCartaoMes != null) {
			setValidadeCartaoMes(validadeCartaoMes);
		}

		Integer validadeCartaoAno = (Integer)attributes.get("validadeCartaoAno");

		if (validadeCartaoAno != null) {
			setValidadeCartaoAno(validadeCartaoAno);
		}

		String nomeTitularCartao = (String)attributes.get("nomeTitularCartao");

		if (nomeTitularCartao != null) {
			setNomeTitularCartao(nomeTitularCartao);
		}

		String codigoSegurancaCartao = (String)attributes.get(
				"codigoSegurancaCartao");

		if (codigoSegurancaCartao != null) {
			setCodigoSegurancaCartao(codigoSegurancaCartao);
		}

		String statusMoedaDigital = (String)attributes.get("statusMoedaDigital");

		if (statusMoedaDigital != null) {
			setStatusMoedaDigital(statusMoedaDigital);
		}

		Integer quantidadeParcelas = (Integer)attributes.get(
				"quantidadeParcelas");

		if (quantidadeParcelas != null) {
			setQuantidadeParcelas(quantidadeParcelas);
		}

		Double valorTotal = (Double)attributes.get("valorTotal");

		if (valorTotal != null) {
			setValorTotal(valorTotal);
		}

		String moedaDigitalPedido = (String)attributes.get("moedaDigitalPedido");

		if (moedaDigitalPedido != null) {
			setMoedaDigitalPedido(moedaDigitalPedido);
		}

		Date dataInicio = (Date)attributes.get("dataInicio");

		if (dataInicio != null) {
			setDataInicio(dataInicio);
		}
	}

	@Override
	public long getInscricaoId() {
		return _inscricaoId;
	}

	@Override
	public void setInscricaoId(long inscricaoId) {
		_inscricaoId = inscricaoId;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setInscricaoId", long.class);

				method.invoke(_cursoInscricaoRemoteModel, inscricaoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_cursoInscricaoRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_cursoInscricaoRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserCreateId() {
		return _userCreateId;
	}

	@Override
	public void setUserCreateId(long userCreateId) {
		_userCreateId = userCreateId;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserCreateId", long.class);

				method.invoke(_cursoInscricaoRemoteModel, userCreateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserCreateName() {
		return _userCreateName;
	}

	@Override
	public void setUserCreateName(String userCreateName) {
		_userCreateName = userCreateName;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserCreateName",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, userCreateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserModifiedId() {
		return _userModifiedId;
	}

	@Override
	public void setUserModifiedId(long userModifiedId) {
		_userModifiedId = userModifiedId;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserModifiedId", long.class);

				method.invoke(_cursoInscricaoRemoteModel, userModifiedId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserModifiedName() {
		return _userModifiedName;
	}

	@Override
	public void setUserModifiedName(String userModifiedName) {
		_userModifiedName = userModifiedName;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserModifiedName",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, userModifiedName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_cursoInscricaoRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_cursoInscricaoRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCursoId() {
		return _cursoId;
	}

	@Override
	public void setCursoId(long cursoId) {
		_cursoId = cursoId;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setCursoId", long.class);

				method.invoke(_cursoInscricaoRemoteModel, cursoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCursoNome() {
		return _cursoNome;
	}

	@Override
	public void setCursoNome(String cursoNome) {
		_cursoNome = cursoNome;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setCursoNome", String.class);

				method.invoke(_cursoInscricaoRemoteModel, cursoNome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCursoData() {
		return _cursoData;
	}

	@Override
	public void setCursoData(String cursoData) {
		_cursoData = cursoData;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setCursoData", String.class);

				method.invoke(_cursoInscricaoRemoteModel, cursoData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCursoHorario() {
		return _cursoHorario;
	}

	@Override
	public void setCursoHorario(String cursoHorario) {
		_cursoHorario = cursoHorario;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setCursoHorario", String.class);

				method.invoke(_cursoInscricaoRemoteModel, cursoHorario);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCursoLocal() {
		return _cursoLocal;
	}

	@Override
	public void setCursoLocal(String cursoLocal) {
		_cursoLocal = cursoLocal;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setCursoLocal", String.class);

				method.invoke(_cursoInscricaoRemoteModel, cursoLocal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPreco() {
		return _preco;
	}

	@Override
	public void setPreco(String preco) {
		_preco = preco;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setPreco", String.class);

				method.invoke(_cursoInscricaoRemoteModel, preco);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrecoConvenio() {
		return _precoConvenio;
	}

	@Override
	public void setPrecoConvenio(String precoConvenio) {
		_precoConvenio = precoConvenio;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setPrecoConvenio", String.class);

				method.invoke(_cursoInscricaoRemoteModel, precoConvenio);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrecoAssociado() {
		return _precoAssociado;
	}

	@Override
	public void setPrecoAssociado(String precoAssociado) {
		_precoAssociado = precoAssociado;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setPrecoAssociado",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, precoAssociado);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTipoFisicaJuridica() {
		return _tipoFisicaJuridica;
	}

	@Override
	public void setTipoFisicaJuridica(String tipoFisicaJuridica) {
		_tipoFisicaJuridica = tipoFisicaJuridica;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setTipoFisicaJuridica",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, tipoFisicaJuridica);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCpfCnpj() {
		return _cpfCnpj;
	}

	@Override
	public void setCpfCnpj(String cpfCnpj) {
		_cpfCnpj = cpfCnpj;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setCpfCnpj", String.class);

				method.invoke(_cursoInscricaoRemoteModel, cpfCnpj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNomeResponsavel() {
		return _nomeResponsavel;
	}

	@Override
	public void setNomeResponsavel(String nomeResponsavel) {
		_nomeResponsavel = nomeResponsavel;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setNomeResponsavel",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, nomeResponsavel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailPrincipal() {
		return _emailPrincipal;
	}

	@Override
	public void setEmailPrincipal(String emailPrincipal) {
		_emailPrincipal = emailPrincipal;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailPrincipal",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, emailPrincipal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDddTelefoneComercial() {
		return _dddTelefoneComercial;
	}

	@Override
	public void setDddTelefoneComercial(String dddTelefoneComercial) {
		_dddTelefoneComercial = dddTelefoneComercial;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setDddTelefoneComercial",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, dddTelefoneComercial);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTelefoneComercial() {
		return _telefoneComercial;
	}

	@Override
	public void setTelefoneComercial(String telefoneComercial) {
		_telefoneComercial = telefoneComercial;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setTelefoneComercial",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, telefoneComercial);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSexo() {
		return _sexo;
	}

	@Override
	public void setSexo(String sexo) {
		_sexo = sexo;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setSexo", String.class);

				method.invoke(_cursoInscricaoRemoteModel, sexo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCadastroFinalizado() {
		return _cadastroFinalizado;
	}

	@Override
	public boolean isCadastroFinalizado() {
		return _cadastroFinalizado;
	}

	@Override
	public void setCadastroFinalizado(boolean cadastroFinalizado) {
		_cadastroFinalizado = cadastroFinalizado;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setCadastroFinalizado",
						boolean.class);

				method.invoke(_cursoInscricaoRemoteModel, cadastroFinalizado);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormaPagamento() {
		return _formaPagamento;
	}

	@Override
	public void setFormaPagamento(String formaPagamento) {
		_formaPagamento = formaPagamento;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setFormaPagamento",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, formaPagamento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNumeroCartao() {
		return _numeroCartao;
	}

	@Override
	public void setNumeroCartao(String numeroCartao) {
		_numeroCartao = numeroCartao;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroCartao", String.class);

				method.invoke(_cursoInscricaoRemoteModel, numeroCartao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getValidadeCartaoMes() {
		return _validadeCartaoMes;
	}

	@Override
	public void setValidadeCartaoMes(int validadeCartaoMes) {
		_validadeCartaoMes = validadeCartaoMes;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setValidadeCartaoMes",
						int.class);

				method.invoke(_cursoInscricaoRemoteModel, validadeCartaoMes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getValidadeCartaoAno() {
		return _validadeCartaoAno;
	}

	@Override
	public void setValidadeCartaoAno(int validadeCartaoAno) {
		_validadeCartaoAno = validadeCartaoAno;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setValidadeCartaoAno",
						int.class);

				method.invoke(_cursoInscricaoRemoteModel, validadeCartaoAno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNomeTitularCartao() {
		return _nomeTitularCartao;
	}

	@Override
	public void setNomeTitularCartao(String nomeTitularCartao) {
		_nomeTitularCartao = nomeTitularCartao;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setNomeTitularCartao",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, nomeTitularCartao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodigoSegurancaCartao() {
		return _codigoSegurancaCartao;
	}

	@Override
	public void setCodigoSegurancaCartao(String codigoSegurancaCartao) {
		_codigoSegurancaCartao = codigoSegurancaCartao;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodigoSegurancaCartao",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, codigoSegurancaCartao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusMoedaDigital() {
		return _statusMoedaDigital;
	}

	@Override
	public void setStatusMoedaDigital(String statusMoedaDigital) {
		_statusMoedaDigital = statusMoedaDigital;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusMoedaDigital",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, statusMoedaDigital);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getQuantidadeParcelas() {
		return _quantidadeParcelas;
	}

	@Override
	public void setQuantidadeParcelas(int quantidadeParcelas) {
		_quantidadeParcelas = quantidadeParcelas;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setQuantidadeParcelas",
						int.class);

				method.invoke(_cursoInscricaoRemoteModel, quantidadeParcelas);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getValorTotal() {
		return _valorTotal;
	}

	@Override
	public void setValorTotal(double valorTotal) {
		_valorTotal = valorTotal;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setValorTotal", double.class);

				method.invoke(_cursoInscricaoRemoteModel, valorTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMoedaDigitalPedido() {
		return _moedaDigitalPedido;
	}

	@Override
	public void setMoedaDigitalPedido(String moedaDigitalPedido) {
		_moedaDigitalPedido = moedaDigitalPedido;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setMoedaDigitalPedido",
						String.class);

				method.invoke(_cursoInscricaoRemoteModel, moedaDigitalPedido);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDataInicio() {
		return _dataInicio;
	}

	@Override
	public void setDataInicio(Date dataInicio) {
		_dataInicio = dataInicio;

		if (_cursoInscricaoRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoRemoteModel.getClass();

				Method method = clazz.getMethod("setDataInicio", Date.class);

				method.invoke(_cursoInscricaoRemoteModel, dataInicio);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCursoInscricaoRemoteModel() {
		return _cursoInscricaoRemoteModel;
	}

	public void setCursoInscricaoRemoteModel(
		BaseModel<?> cursoInscricaoRemoteModel) {
		_cursoInscricaoRemoteModel = cursoInscricaoRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _cursoInscricaoRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_cursoInscricaoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CursoInscricaoLocalServiceUtil.addCursoInscricao(this);
		}
		else {
			CursoInscricaoLocalServiceUtil.updateCursoInscricao(this);
		}
	}

	@Override
	public CursoInscricao toEscapedModel() {
		return (CursoInscricao)ProxyUtil.newProxyInstance(CursoInscricao.class.getClassLoader(),
			new Class[] { CursoInscricao.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CursoInscricaoClp clone = new CursoInscricaoClp();

		clone.setInscricaoId(getInscricaoId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserCreateId(getUserCreateId());
		clone.setUserCreateName(getUserCreateName());
		clone.setUserModifiedId(getUserModifiedId());
		clone.setUserModifiedName(getUserModifiedName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCursoId(getCursoId());
		clone.setCursoNome(getCursoNome());
		clone.setCursoData(getCursoData());
		clone.setCursoHorario(getCursoHorario());
		clone.setCursoLocal(getCursoLocal());
		clone.setPreco(getPreco());
		clone.setPrecoConvenio(getPrecoConvenio());
		clone.setPrecoAssociado(getPrecoAssociado());
		clone.setTipoFisicaJuridica(getTipoFisicaJuridica());
		clone.setCpfCnpj(getCpfCnpj());
		clone.setNomeResponsavel(getNomeResponsavel());
		clone.setEmailPrincipal(getEmailPrincipal());
		clone.setDddTelefoneComercial(getDddTelefoneComercial());
		clone.setTelefoneComercial(getTelefoneComercial());
		clone.setSexo(getSexo());
		clone.setCadastroFinalizado(getCadastroFinalizado());
		clone.setFormaPagamento(getFormaPagamento());
		clone.setNumeroCartao(getNumeroCartao());
		clone.setValidadeCartaoMes(getValidadeCartaoMes());
		clone.setValidadeCartaoAno(getValidadeCartaoAno());
		clone.setNomeTitularCartao(getNomeTitularCartao());
		clone.setCodigoSegurancaCartao(getCodigoSegurancaCartao());
		clone.setStatusMoedaDigital(getStatusMoedaDigital());
		clone.setQuantidadeParcelas(getQuantidadeParcelas());
		clone.setValorTotal(getValorTotal());
		clone.setMoedaDigitalPedido(getMoedaDigitalPedido());
		clone.setDataInicio(getDataInicio());

		return clone;
	}

	@Override
	public int compareTo(CursoInscricao cursoInscricao) {
		int value = 0;

		value = getCursoNome().compareTo(cursoInscricao.getCursoNome());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CursoInscricaoClp)) {
			return false;
		}

		CursoInscricaoClp cursoInscricao = (CursoInscricaoClp)obj;

		long primaryKey = cursoInscricao.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(73);

		sb.append("{inscricaoId=");
		sb.append(getInscricaoId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userCreateId=");
		sb.append(getUserCreateId());
		sb.append(", userCreateName=");
		sb.append(getUserCreateName());
		sb.append(", userModifiedId=");
		sb.append(getUserModifiedId());
		sb.append(", userModifiedName=");
		sb.append(getUserModifiedName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", cursoId=");
		sb.append(getCursoId());
		sb.append(", cursoNome=");
		sb.append(getCursoNome());
		sb.append(", cursoData=");
		sb.append(getCursoData());
		sb.append(", cursoHorario=");
		sb.append(getCursoHorario());
		sb.append(", cursoLocal=");
		sb.append(getCursoLocal());
		sb.append(", preco=");
		sb.append(getPreco());
		sb.append(", precoConvenio=");
		sb.append(getPrecoConvenio());
		sb.append(", precoAssociado=");
		sb.append(getPrecoAssociado());
		sb.append(", tipoFisicaJuridica=");
		sb.append(getTipoFisicaJuridica());
		sb.append(", cpfCnpj=");
		sb.append(getCpfCnpj());
		sb.append(", nomeResponsavel=");
		sb.append(getNomeResponsavel());
		sb.append(", emailPrincipal=");
		sb.append(getEmailPrincipal());
		sb.append(", dddTelefoneComercial=");
		sb.append(getDddTelefoneComercial());
		sb.append(", telefoneComercial=");
		sb.append(getTelefoneComercial());
		sb.append(", sexo=");
		sb.append(getSexo());
		sb.append(", cadastroFinalizado=");
		sb.append(getCadastroFinalizado());
		sb.append(", formaPagamento=");
		sb.append(getFormaPagamento());
		sb.append(", numeroCartao=");
		sb.append(getNumeroCartao());
		sb.append(", validadeCartaoMes=");
		sb.append(getValidadeCartaoMes());
		sb.append(", validadeCartaoAno=");
		sb.append(getValidadeCartaoAno());
		sb.append(", nomeTitularCartao=");
		sb.append(getNomeTitularCartao());
		sb.append(", codigoSegurancaCartao=");
		sb.append(getCodigoSegurancaCartao());
		sb.append(", statusMoedaDigital=");
		sb.append(getStatusMoedaDigital());
		sb.append(", quantidadeParcelas=");
		sb.append(getQuantidadeParcelas());
		sb.append(", valorTotal=");
		sb.append(getValorTotal());
		sb.append(", moedaDigitalPedido=");
		sb.append(getMoedaDigitalPedido());
		sb.append(", dataInicio=");
		sb.append(getDataInicio());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(112);

		sb.append("<model><model-name>");
		sb.append("br.com.cnf.curso.inscricao.model.CursoInscricao");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>inscricaoId</column-name><column-value><![CDATA[");
		sb.append(getInscricaoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userCreateId</column-name><column-value><![CDATA[");
		sb.append(getUserCreateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userCreateName</column-name><column-value><![CDATA[");
		sb.append(getUserCreateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userModifiedId</column-name><column-value><![CDATA[");
		sb.append(getUserModifiedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userModifiedName</column-name><column-value><![CDATA[");
		sb.append(getUserModifiedName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cursoId</column-name><column-value><![CDATA[");
		sb.append(getCursoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cursoNome</column-name><column-value><![CDATA[");
		sb.append(getCursoNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cursoData</column-name><column-value><![CDATA[");
		sb.append(getCursoData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cursoHorario</column-name><column-value><![CDATA[");
		sb.append(getCursoHorario());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cursoLocal</column-name><column-value><![CDATA[");
		sb.append(getCursoLocal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>preco</column-name><column-value><![CDATA[");
		sb.append(getPreco());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>precoConvenio</column-name><column-value><![CDATA[");
		sb.append(getPrecoConvenio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>precoAssociado</column-name><column-value><![CDATA[");
		sb.append(getPrecoAssociado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoFisicaJuridica</column-name><column-value><![CDATA[");
		sb.append(getTipoFisicaJuridica());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cpfCnpj</column-name><column-value><![CDATA[");
		sb.append(getCpfCnpj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomeResponsavel</column-name><column-value><![CDATA[");
		sb.append(getNomeResponsavel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailPrincipal</column-name><column-value><![CDATA[");
		sb.append(getEmailPrincipal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dddTelefoneComercial</column-name><column-value><![CDATA[");
		sb.append(getDddTelefoneComercial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefoneComercial</column-name><column-value><![CDATA[");
		sb.append(getTelefoneComercial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sexo</column-name><column-value><![CDATA[");
		sb.append(getSexo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cadastroFinalizado</column-name><column-value><![CDATA[");
		sb.append(getCadastroFinalizado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formaPagamento</column-name><column-value><![CDATA[");
		sb.append(getFormaPagamento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroCartao</column-name><column-value><![CDATA[");
		sb.append(getNumeroCartao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validadeCartaoMes</column-name><column-value><![CDATA[");
		sb.append(getValidadeCartaoMes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validadeCartaoAno</column-name><column-value><![CDATA[");
		sb.append(getValidadeCartaoAno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomeTitularCartao</column-name><column-value><![CDATA[");
		sb.append(getNomeTitularCartao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigoSegurancaCartao</column-name><column-value><![CDATA[");
		sb.append(getCodigoSegurancaCartao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusMoedaDigital</column-name><column-value><![CDATA[");
		sb.append(getStatusMoedaDigital());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantidadeParcelas</column-name><column-value><![CDATA[");
		sb.append(getQuantidadeParcelas());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valorTotal</column-name><column-value><![CDATA[");
		sb.append(getValorTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moedaDigitalPedido</column-name><column-value><![CDATA[");
		sb.append(getMoedaDigitalPedido());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataInicio</column-name><column-value><![CDATA[");
		sb.append(getDataInicio());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _inscricaoId;
	private long _companyId;
	private long _groupId;
	private long _userCreateId;
	private String _userCreateName;
	private long _userModifiedId;
	private String _userModifiedName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _cursoId;
	private String _cursoNome;
	private String _cursoData;
	private String _cursoHorario;
	private String _cursoLocal;
	private String _preco;
	private String _precoConvenio;
	private String _precoAssociado;
	private String _tipoFisicaJuridica;
	private String _cpfCnpj;
	private String _nomeResponsavel;
	private String _emailPrincipal;
	private String _dddTelefoneComercial;
	private String _telefoneComercial;
	private String _sexo;
	private boolean _cadastroFinalizado;
	private String _formaPagamento;
	private String _numeroCartao;
	private int _validadeCartaoMes;
	private int _validadeCartaoAno;
	private String _nomeTitularCartao;
	private String _codigoSegurancaCartao;
	private String _statusMoedaDigital;
	private int _quantidadeParcelas;
	private double _valorTotal;
	private String _moedaDigitalPedido;
	private Date _dataInicio;
	private BaseModel<?> _cursoInscricaoRemoteModel;
	private Class<?> _clpSerializerClass = br.com.cnf.curso.inscricao.service.ClpSerializer.class;
}