package org.finos.waltz.data.entity_alias;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.OrderField;
import org.jooq.Record1;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSeekStep1;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntityAliasDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private EntityAliasDao entityAliasDao;

  /**
   * Test {@link EntityAliasDao#findAliasesForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasDao#findAliasesForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findAliasesForEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityAliasDao.findAliasesForEntityReference(EntityReference)"})
  void testFindAliasesForEntityReference_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record1<Object>, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<Field<Object>>any())).thenReturn(new ArrayList<>());

    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    List<String> actualFindAliasesForEntityReferenceResult =
        entityAliasDao.findAliasesForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSeekStep1).fetch(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAliasesForEntityReferenceResult.isEmpty());
  }
}
