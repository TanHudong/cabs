package org.neu.cabs.dao;

import org.neu.cabs.orm.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 订单数据持久化接口
 * @author 李浩然
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Transactional(rollbackFor = Exception.class)
public interface OrderRepository extends JpaRepository<Order, Long> {
    /**
     * 查询时间范围内的订单
     * @param start 开始时间
     * @param end 结束时间
     * @return 订单列表
     */
    List<Order> findAllByCreateTimeBetween(Date start, Date end);

    /**
     * 分页查询时间范围内的订单
     * @param start 开始时间
     * @param end 结束时间
     * @param pageable 分页信息
     * @return 分页订单
     */
    Page<Order> findAllByCreateTimeBetween(Date start, Date end, Pageable pageable);

}
