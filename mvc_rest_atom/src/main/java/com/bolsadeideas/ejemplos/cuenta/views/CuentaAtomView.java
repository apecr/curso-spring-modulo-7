/*
 * Copyright 2002-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bolsadeideas.ejemplos.cuenta.views;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bolsadeideas.ejemplos.cuenta.domain.Cuenta;
import com.rometools.rome.feed.atom.Content;
import com.rometools.rome.feed.atom.Entry;
import com.rometools.rome.feed.atom.Feed;

import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

public class CuentaAtomView extends AbstractAtomFeedView {

	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Feed feed, HttpServletRequest request) {
		feed.setId("tag:bolsadeideas.com");
		feed.setTitle("Lista de cuentas");
		@SuppressWarnings("unchecked")
		List<Cuenta> cuentas = (List<Cuenta>)model.get("cuentas");
		for (Cuenta cuenta : cuentas) {
			Date fecha = cuenta.getFechaRenovacion();
			if (feed.getUpdated() == null || fecha.compareTo(feed.getUpdated()) > 0) {
				feed.setUpdated(fecha);
			}
		}
	}

	@Override
	protected List<Entry> buildFeedEntries(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Cuenta> cuentas = (List<Cuenta>)model.get("cuentas");
		List<Entry> entradas = new ArrayList<Entry>(cuentas.size());

		for (Cuenta cuenta : cuentas) {
			Entry entrada = new Entry();
			String fecha = String.format("%1$tY-%1$tm-%1$td", cuenta.getFechaRenovacion());
			entrada.setId(String.format("tag:bolsadeideas.com,%s:%d", fecha, cuenta.getId()));
			entrada.setTitle(String.format("On %s, escrito por %s", fecha, cuenta.getNombre()));
			entrada.setUpdated(cuenta.getFechaRenovacion());
			Content contenido = new Content();
			contenido.setValue("Algún contenido resumido de la entrada ...");
			entrada.setSummary(contenido);
			entradas.add(entrada);
		}

		return entradas;
	}
}
