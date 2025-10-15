package org.finos.waltz.service.allocation_schemes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.allocation_scheme.AllocationSchemeDao;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.allocation_scheme.ImmutableAllocationScheme;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AllocationSchemeServiceDiffblueTest {
  @Mock private AllocationSchemeDao allocationSchemeDao;

  @InjectMocks private AllocationSchemeService allocationSchemeService;

  /**
   * Test {@link AllocationSchemeService#findAll()}.
   *
   * <p>Method under test: {@link AllocationSchemeService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllocationSchemeService.findAll()"})
  void testFindAll() {
    // Arrange
    when(allocationSchemeDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<AllocationScheme> actualFindAllResult = allocationSchemeService.findAll();

    // Assert
    verify(allocationSchemeDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link AllocationSchemeService#findByCategoryId(long)}.
   *
   * <p>Method under test: {@link AllocationSchemeService#findByCategoryId(long)}
   */
  @Test
  @DisplayName("Test findByCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllocationSchemeService.findByCategoryId(long)"})
  void testFindByCategoryId() {
    // Arrange
    when(allocationSchemeDao.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<AllocationScheme> actualFindByCategoryIdResult =
        allocationSchemeService.findByCategoryId(1L);

    // Assert
    verify(allocationSchemeDao).findByCategoryId(1L);
    assertTrue(actualFindByCategoryIdResult.isEmpty());
  }

  /**
   * Test {@link AllocationSchemeService#getById(long)}.
   *
   * <p>Method under test: {@link AllocationSchemeService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AllocationScheme AllocationSchemeService.getById(long)"})
  void testGetById() {
    // Arrange
    when(allocationSchemeDao.getById(anyLong()))
        .thenReturn(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    // Act
    AllocationScheme actualById = allocationSchemeService.getById(1L);

    // Assert
    verify(allocationSchemeDao).getById(1L);
    assertTrue(actualById instanceof ImmutableAllocationScheme);
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.measurableCategoryId());
  }

  /**
   * Test {@link AllocationSchemeService#create(AllocationScheme)}.
   *
   * <p>Method under test: {@link AllocationSchemeService#create(AllocationScheme)}
   */
  @Test
  @DisplayName("Test create(AllocationScheme)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AllocationSchemeService.create(AllocationScheme)"})
  void testCreate() {
    // Arrange
    when(allocationSchemeDao.create(Mockito.<AllocationScheme>any())).thenReturn(1L);

    // Act
    long actualCreateResult = allocationSchemeService.create(null);

    // Assert
    verify(allocationSchemeDao).create(isNull());
    assertEquals(1L, actualCreateResult);
  }
}
