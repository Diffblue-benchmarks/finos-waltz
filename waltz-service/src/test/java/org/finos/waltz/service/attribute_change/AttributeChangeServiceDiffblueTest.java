package org.finos.waltz.service.attribute_change;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.attribute_change.AttributeChangeDao;
import org.finos.waltz.model.attribute_change.AttributeChange;
import org.finos.waltz.model.attribute_change.ImmutableAttributeChange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AttributeChangeServiceDiffblueTest {
  @Mock private AttributeChangeDao attributeChangeDao;

  @InjectMocks private AttributeChangeService attributeChangeService;

  /**
   * Test {@link AttributeChangeService#getById(long)}.
   *
   * <p>Method under test: {@link AttributeChangeService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeChange AttributeChangeService.getById(long)"})
  void testGetById() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(attributeChangeDao.getById(anyLong()))
        .thenReturn(
            ImmutableAttributeChange.builder()
                .changeUnitId(1L)
                .id(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .newValue("42")
                .oldValue("42")
                .provenance("Provenance")
                .type("Type")
                .build());

    // Act
    AttributeChange actualById = attributeChangeService.getById(1L);

    // Assert
    verify(attributeChangeDao).getById(1L);
    assertTrue(actualById instanceof ImmutableAttributeChange);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("42", actualById.newValue());
    assertEquals("42", actualById.oldValue());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("Type", actualById.type());
    assertEquals(1L, actualById.changeUnitId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link AttributeChangeService#findByChangeUnitId(long)}.
   *
   * <p>Method under test: {@link AttributeChangeService#findByChangeUnitId(long)}
   */
  @Test
  @DisplayName("Test findByChangeUnitId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttributeChangeService.findByChangeUnitId(long)"})
  void testFindByChangeUnitId() {
    // Arrange
    when(attributeChangeDao.findByChangeUnitId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<AttributeChange> actualFindByChangeUnitIdResult =
        attributeChangeService.findByChangeUnitId(1L);

    // Assert
    verify(attributeChangeDao).findByChangeUnitId(1L);
    assertTrue(actualFindByChangeUnitIdResult.isEmpty());
  }
}
