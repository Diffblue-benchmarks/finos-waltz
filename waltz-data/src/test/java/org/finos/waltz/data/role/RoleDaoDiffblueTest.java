package org.finos.waltz.data.role;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.role.ImmutableRole;
import org.finos.waltz.model.role.Role;
import org.finos.waltz.schema.tables.records.RoleRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RoleDaoDiffblueTest {
  /**
   * Test {@link RoleDao#create(RoleRecord)}.
   *
   * <ul>
   *   <li>Given {@link InsertResultStep} {@link InsertResultStep#fetchOne()} return {@link
   *       RoleRecord#RoleRecord()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RoleDao#create(RoleRecord)}
   */
  @Test
  @DisplayName(
      "Test create(RoleRecord); given InsertResultStep fetchOne() return RoleRecord(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RoleDao.create(RoleRecord)"})
  void testCreate_givenInsertResultStepFetchOneReturnRoleRecord_thenReturnNull()
      throws DataAccessException {
    // Arrange
    InsertResultStep<RoleRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new RoleRecord());

    InsertSetMoreStep<RoleRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<RoleRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<RoleRecord>>any())).thenReturn(insertSetStep);
    RoleDao roleDao = new RoleDao(dsl);

    // Act
    Long actualCreateResult = roleDao.create(new RoleRecord());

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link RoleDao#findAllRoles()}.
   *
   * <p>Method under test: {@link RoleDao#findAllRoles()}
   */
  @Test
  @DisplayName("Test findAllRoles()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RoleDao.findAllRoles()"})
  void testFindAllRoles() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<Role> actualFindAllRolesResult = new RoleDao(dsl).findAllRoles();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllRolesResult.isEmpty());
  }

  /**
   * Test {@link RoleDao#getRoleById(Long)}.
   *
   * <p>Method under test: {@link RoleDao#getRoleById(Long)}
   */
  @Test
  @DisplayName("Test getRoleById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Role RoleDao.getRoleById(Long)"})
  void testGetRoleById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableRole.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .isCustom(true)
                .key("Key")
                .name("Name")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Role actualRoleById = new RoleDao(dsl).getRoleById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualRoleById instanceof ImmutableRole);
    assertEquals("Key", actualRoleById.key());
    assertEquals("Name", actualRoleById.name());
    assertEquals("The characteristics of someone or something", actualRoleById.description());
    assertTrue(actualRoleById.isCustom());
    assertTrue(actualRoleById.userSelectable());
  }
}
