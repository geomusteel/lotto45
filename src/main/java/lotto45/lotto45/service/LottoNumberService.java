package lotto45.lotto45.service;

import lotto45.lotto45.domain.Lotto;

import java.util.List;
import java.util.Queue;

public interface LottoNumberService {

    Lotto create();
    List<Lotto> findByRounds(int rounds);
    List<Lotto> findAll();
    List<Lotto> lastLottoNumber8();

}
