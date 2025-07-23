//package com.example.taco_cloud.repository;
//
//import com.example.taco_cloud.domain.Ingredient;
//import com.example.taco_cloud.domain.IngredientRef;
//import com.example.taco_cloud.domain.Order;
//import com.example.taco_cloud.domain.Taco;
//import org.springframework.asm.Type;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcOperations;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.sql.Types;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//@Repository
//public class JdbcOrderRepository implements OrderRepository {
//
//    private final JdbcOperations operations;
//
//    @Autowired
//    public JdbcOrderRepository(JdbcOperations operations) {
//        this.operations = operations;
//    }
//
//    @Override
//    @Transactional
//    public Order save(Order order) {
//        PreparedStatementCreatorFactory statementCreatorFactory =
//                new PreparedStatementCreatorFactory(
//                        "INSERT INTO Taco_Order "
//                        + "(delivery_name, delivery_street, delivery_city, "
//                        + "delivery_state, delivery_zip, cc_number, "
//                        + "cc_expiration, cc_cvv, placed_at) "
//                        + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
//                        Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
//                        Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
//                        Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
//                );
//
//        statementCreatorFactory.setReturnGeneratedKeys(true);
//
//        order.setPlacedAt(new Date());
//
//        PreparedStatementCreator creator =
//                statementCreatorFactory.newPreparedStatementCreator(
//                        Arrays.asList(
//                                order.getDeliveryName(),
//                                order.getDeliveryState(),
//                                order.getDeliveryCity(),
//                                order.getDeliveryState(),
//                                order.getDeliveryZip(),
//                                order.getCcNumber(),
//                                order.getCcExpiration(),
//                                order.getCcCVV(),
//                                order.getPlacedAt()
//                        )
//                );
//
//        GeneratedKeyHolder holder = new GeneratedKeyHolder();
//        operations.update(creator, holder);
//        long orderId = holder.getKey().longValue();
//        order.setId(orderId);
//
//        List<Taco> tacos = order.getTacos();
//        int tacoNumber = 0;
//        for (Taco taco : tacos) {
//            saveTaco(orderId, tacoNumber, taco);
//        }
//
//        return order;
//    }
//
//    private long saveTaco(Long orderId, int orderKey, Taco taco) {
//        taco.setCreatedAt(new Date());
//
//        PreparedStatementCreatorFactory factory = new PreparedStatementCreatorFactory(
//                "INSERT INTO Taco "
//                + "(name, created_at, taco_order, taco_order_key) "
//                + "values (?, ?, ?, ?)",
//                Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG
//        );
//
//        factory.setReturnGeneratedKeys(true);
//
//        PreparedStatementCreator creator =
//                factory.newPreparedStatementCreator(
//                        Arrays.asList(
//                                taco.getName(),
//                                taco.getCreatedAt(),
//                                orderId,
//                                orderKey
//                        )
//                );
//
//        GeneratedKeyHolder holder = new GeneratedKeyHolder();
//        operations.update(creator, holder);
//        long tacoId = holder.getKey().longValue();
//        taco.setId(tacoId);
//
//        saveIngredientsRef(tacoId, taco.getIngredients());
//
//        return tacoId;
//    }
//
//    private void saveIngredientsRef(long tacoId, List<IngredientRef> ingredientRefs) {
//        int key = 0;
//        for (IngredientRef ingredientRef : ingredientRefs) {
//            operations.update(
//                    "INSERT INTO Ingredient_Ref (ingredient, taco, taco_key) "
//                    + "values (?, ?, ?)",
//                    ingredientRef.getIngredient(), tacoId, key++
//            );
//        }
//    }
//}
