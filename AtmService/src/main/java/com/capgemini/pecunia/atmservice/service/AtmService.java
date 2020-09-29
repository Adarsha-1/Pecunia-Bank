package com.capgemini.pecunia.atmservice.service;

import com.capgemini.pecunia.atmservice.dto.AtmRegistry;

public interface AtmService {

	public AtmRegistry blockAtmCard(long atmNumber);
	public AtmRegistry requestAtmCard(long accountNumber);
}
