package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableTabularRowDiffblueTest {
  /**
   * Method under test: {@link ImmutableTabularRow.Builder#from(TabularRow)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTabularRow.Builder builderResult = ImmutableTabularRow.builder();
    TabularRow instance = mock(TabularRow.class);
    when(instance.rowNumber()).thenReturn(10);
    when(instance.values()).thenReturn(new String[]{"42"});

    // Act
    ImmutableTabularRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).rowNumber();
    verify(instance).values();
    assertEquals(10, actualFromResult.build().rowNumber());
    assertEquals(10, builderResult.build().rowNumber());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTabularRow.Builder#from(TabularRow)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableTabularRow.Builder builderResult = ImmutableTabularRow.builder();
    TabularRow instance = mock(TabularRow.class);
    when(instance.rowNumber()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).rowNumber();
  }

  /**
   * Method under test: {@link ImmutableTabularRow.Builder#rowNumber(int)}
   */
  @Test
  void testBuilderRowNumber() {
    // Arrange
    ImmutableTabularRow.Builder builderResult = ImmutableTabularRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rowNumber(10));
  }

  /**
   * Method under test: {@link ImmutableTabularRow.Builder#values(String[])}
   */
  @Test
  void testBuilderValues() {
    // Arrange
    ImmutableTabularRow.Builder builderResult = ImmutableTabularRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.values("42"));
  }

  /**
   * Method under test: {@link ImmutableTabularRow#copyOf(TabularRow)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    TabularRow instance = mock(TabularRow.class);
    when(instance.rowNumber()).thenReturn(10);
    when(instance.values()).thenReturn(new String[]{"42"});

    // Act
    ImmutableTabularRow actualCopyOfResult = ImmutableTabularRow.copyOf(instance);

    // Assert
    verify(instance).rowNumber();
    verify(instance).values();
    assertEquals(10, actualCopyOfResult.rowNumber());
  }
}
