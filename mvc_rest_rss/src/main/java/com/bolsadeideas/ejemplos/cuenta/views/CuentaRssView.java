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

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.bolsadeideas.ejemplos.cuenta.domain.Cuenta;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Item;


public class CuentaRssView extends AbstractRssFeedView {

	// Poblar los datos para el feed (title, link, description, etc.). 
	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
			HttpServletRequest request) {
		feed.setTitle("Lista de cuentas");
		feed.setDescription("Ejemplo RSS feed");
		feed.setLink("www.bolsadeideas.com");

		@SuppressWarnings("unchecked")
		List<Cuenta> cuentas = (List<Cuenta>) model.get("cuentas");

		for (Cuenta cuenta : cuentas) {
			Date fecha = cuenta.getFechaRenovacion();
			if ((feed.getLastBuildDate() == null)
					|| (fecha.compareTo(feed.getLastBuildDate()) > 0)) {
				feed.setLastBuildDate(fecha);
			}
		}
	}

	// Construimos el feed a partir de las cuentas
	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Cuenta> cuentas = (List<Cuenta>) model.get("cuentas");
		List<Item> items = new ArrayList<Item>(cuentas.size());

		for (Cuenta cuenta : cuentas) {
			Item item = new Item();
			item.setAuthor(cuenta.getNombre());
			item.setTitle(String.format("%s - Publicado por %s",
					cuenta.getNombre(), cuenta.getNombre()));
			item.setPubDate(cuenta.getFechaRenovacion());
			item.setLink("http://localhost:8080/mvc_rest_rss/cuentas/"+cuenta.getId());
			items.add(item);
		}

		return items;
	}

}
