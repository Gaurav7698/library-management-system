package com.sctpl.admin.g1.library123.service.impl;

import com.sctpl.admin.g1.library123.domain.Card;
import com.sctpl.admin.g1.library123.repository.CardRepository;
import com.sctpl.admin.g1.library123.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;
    @Override
    public Card saveCard(Card libraryCard) {
        return cardRepository.save(libraryCard);
    }

    @Override
    public Card fetchById(Integer cardId) {

        return cardRepository.fetchById(cardId);
    }

    @Override
    public List<Card> fetchAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card update(Card libraryCard) {
        return null;
    }
}
