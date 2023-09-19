/*
 * Engineering Ingegneria Informatica S.p.A.
 *
 * Copyright (C) 2023 Regione Emilia-Romagna
 * <p/>
 * This program is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Affero General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package es.mityc.firmaJava.libreria.xades;

import java.net.URI;
import java.util.ArrayList;

import org.apache.xml.security.signature.XMLSignature;
import org.w3c.dom.Document;

import es.mityc.firmaJava.libreria.ConstantesXADES;
import es.mityc.javasign.certificate.ICertStatus;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */

public class ResultadoValidacion { // implements ConstantesXADES

    private boolean validado;
    private ResultadoEnum resultado;
    private String log;
    private String nivelValido;
    private EnumFormatoFirma EnumNivel; // Ãšltimo nivel validado
    private Document doc;
    private DatosFirma datosFirma;
    private XMLSignature xmlSignature;
    private URI baseURI;
    private ArrayList<String> firmados;
    private ArrayList<ResultadoValidacion> contrafirmadoPor;
    private ICertStatus certStatus = null;

    /**
     * Crea una nueva instancia de ValidationResult()
     * 
     * Los datos que contiene son: boolean validado.- Estado de validez de la firma ResultadoEnum resultado.- Estructura
     * de datos de resultado de validacion String log .- AlmacÃ©n de mensajes a mostrar en cliente String nivelValido .-
     * Mensaje con el Ãºltimo nivel XAdES valido EnumFormatoFirma EnumNivel.- Nivel XAdES de la firma (sin validar)
     * Document doc .- El documento de firma DatosFirma datosFirma.- Estructura de datos de firma URI baseURI .- URI de
     * base de la firma (ruta donde se encuentra) ArrayList<String> firmados.- Ficheros firmados por la firma
     * ArrayList<ResultadoValidacion> contrafirmadoPor .- Nodos que contrafirman a Ã©sta firma String certRevokedMsg .-
     * Causa de invalidez de un certificado
     */
    public ResultadoValidacion() {
        this.validado = false;
        this.resultado = ResultadoEnum.UNKNOWN;
        this.log = ConstantesXADES.CADENA_VACIA;
        this.nivelValido = ConstantesXADES.CADENA_VACIA;
        this.firmados = new ArrayList<String>();
        this.contrafirmadoPor = new ArrayList<ResultadoValidacion>();

    }

    /**
     * 
     * @return
     */
    public String getLog() {
        return log;
    }

    /**
     * 
     * @param log
     */
    public void setLog(String log) {
        this.log = this.log.length() == 0 ? log : this.log + " - " + log;
    }

    /**
     * 
     * @return
     */
    public boolean isValidate() {
        return validado;
    }

    /**
     * 
     * @param validado
     */
    public void setValidate(boolean validado) {
        this.validado = validado;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    /**
     * 
     * @return
     */
    public String getNivelValido() {
        return nivelValido;
    }

    /**
     * 
     * @param log
     */
    public void setNivelValido(String nivelValido) {
        this.nivelValido = nivelValido;
    }

    /**
     * 
     * @return
     */
    public DatosFirma getDatosFirma() {
        return datosFirma;
    }

    /**
     * 
     * @param datosFirma
     */
    public void setDatosFirma(DatosFirma datosFirma) {
        this.datosFirma = datosFirma;
    }

    /**
     * Ãšltimo nivel validado
     * 
     * @return EnumNivel
     */
    public EnumFormatoFirma getEnumNivel() {
        return EnumNivel;
    }

    /**
     * Ãšltimo nivel validado
     * 
     * @param enumNivel
     */
    public void setEnumNivel(EnumFormatoFirma enumNivel) {
        EnumNivel = enumNivel;
    }

    /**
     * Devuelve la URI de base del XML de firma
     * 
     * @return URI
     */
    public URI getBaseURI() {
        return baseURI;
    }

    /**
     * Establece la URI de base del XML de firma
     * 
     * @param URI
     */
    public void setBaseURI(URI baseURI) {
        this.baseURI = baseURI;
    }

    /**
     * Devuelve la lista de nodos (externos a la firma) firmados
     * 
     * @return ArrayList<String> .- ArrayList de URIs
     */
    public ArrayList<String> getFirmados() {
        return firmados;
    }

    /**
     * Establece la lista de nodos (externos a la firma) firmados
     */
    public void setFirmados(ArrayList<String> firmados) {
        this.firmados = firmados;
    }

    /**
     * Array de resultados de validacion de las firmas que contrafirman a Ã©sta
     * 
     * @return ArrayList<ResultadoValidacion>
     */
    public ArrayList<ResultadoValidacion> getContrafirmadoPor() {
        return contrafirmadoPor;
    }

    /**
     * Establece el array de resultados de validacion de las firmas que contrafirman a Ã©sta
     * 
     * @param ArrayList<ResultadoValidacion>
     */
    public void setContrafirmadoPor(ArrayList<ResultadoValidacion> contrafirmadoPor) {
        this.contrafirmadoPor = contrafirmadoPor;
    }

    /**
     * AÃ±ade al array de resultados de validacion de las firmas que contrafirman a Ã©sta otro resultado de validacion
     * 
     * @param ResultadoValidacion
     */
    public void addContrafirmadoPor(ResultadoValidacion contrafirmadoPor) {
        if (contrafirmadoPor != null)
            this.contrafirmadoPor.add(contrafirmadoPor);
    }

    /**
     * Recupera el estado del certificado de firma.
     * 
     * @return Estado del certificado de firma, o <code>null</code> si no se ha obtenido.
     */
    public ICertStatus getCertStatus() {
        return certStatus;
    }

    /**
     * Establece el estado del certificado firmante.
     * 
     * @param certStatus
     *            Estado del certificado firmante, <code>null</code> si no se ha obtenido
     */
    public void setCertStatus(ICertStatus certStatus) {
        this.certStatus = certStatus;
    }

    public XMLSignature getXmlSignature() {
        return xmlSignature;
    }

    public void setXmlSignature(XMLSignature xmlSignature) {
        this.xmlSignature = xmlSignature;
    }
}
