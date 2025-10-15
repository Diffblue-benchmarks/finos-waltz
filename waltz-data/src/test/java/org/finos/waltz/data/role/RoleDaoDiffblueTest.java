package org.finos.waltz.data.role;

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
import org.finos.waltz.model.role.Role;
import org.finos.waltz.schema.tables.records.RoleRecord;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
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
class RoleDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private RoleDao roleDao;

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
    when(dSLContext.insertInto(Mockito.<Table<RoleRecord>>any())).thenReturn(insertSetStep);

    // Act
    Long actualCreateResult = roleDao.create(new RoleRecord());

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<Role> actualFindAllRolesResult = roleDao.findAllRoles();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllRolesResult.isEmpty());
  }
}
