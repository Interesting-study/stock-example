package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;


@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

//    @Transactional
    public synchronized void decrease(Long id, Long quantity){ // 한번에 1개의 스레드만 접근 가능
        //get stock
        //재고감소
        //저장
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);
        stockRepository.saveAndFlush(stock);
    }

    /*
    * synchronized 하나의 프로세스에서만 보장됨
    * 서버가 하나일 땐 괜찮지만, 두개 이상의 서버일 땐 사용하지 않을 때와 같게 됨
    * */
}
