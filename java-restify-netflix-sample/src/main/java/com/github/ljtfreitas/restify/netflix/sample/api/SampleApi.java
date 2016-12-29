package com.github.ljtfreitas.restify.netflix.sample.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/api/sample")
public class SampleApi extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ObjectMapper objectMapper;

	@Override
	public void init() throws ServletException {
		super.init();

		objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		write(new SampleObject("My Api GET response. Received on [" + req.getServerName() + ":" + req.getServerPort() + "]"), resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SampleObject object = objectMapper.readValue(req.getInputStream(), SampleObject.class);

		write(new SampleObject("My Api POST response. Original sample object is [" + object + "]. "
				+ "Received on [" + req.getServerName() + ":" + req.getServerPort() + "]"), resp);
	}

	private void write(SampleObject myApiResponse, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		resp.setStatus(HttpServletResponse.SC_OK);

		ServletOutputStream output = resp.getOutputStream();

		objectMapper.writeValue(output, myApiResponse);

		output.flush();
	}
}
