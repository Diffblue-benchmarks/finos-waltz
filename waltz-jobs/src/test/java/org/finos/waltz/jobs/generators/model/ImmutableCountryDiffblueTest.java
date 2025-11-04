package org.finos.waltz.jobs.generators.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableCountryDiffblueTest {
  /**
   * Method under test: {@link ImmutableCountry.Builder#code(String)}
   */
  @Test
  void testBuilderCode() {
    // Arrange
    ImmutableCountry.Builder builderResult = ImmutableCountry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.code("Code"));
  }

  /**
   * Method under test: {@link ImmutableCountry.Builder#from(Country)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCountry.Builder builderResult = ImmutableCountry.builder();
    Country instance = mock(Country.class);
    when(instance.regionCode()).thenReturn("us-east-2");
    when(instance.region()).thenReturn("us-east-2");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCountry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    verify(instance).name();
    verify(instance).region();
    verify(instance).regionCode();
    ImmutableCountry buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("us-east-2", buildResult.region());
    assertEquals("us-east-2", buildResult.regionCode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCountry.Builder#from(Country)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCountry.Builder builderResult = ImmutableCountry.builder();
    Country instance = mock(Country.class);
    when(instance.regionCode()).thenThrow(new IllegalStateException("instance"));
    when(instance.region()).thenReturn("us-east-2");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
    verify(instance).name();
    verify(instance).region();
    verify(instance).regionCode();
  }

  /**
   * Method under test: {@link ImmutableCountry.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableCountry.Builder builderResult = ImmutableCountry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableCountry.Builder#region(String)}
   */
  @Test
  void testBuilderRegion() {
    // Arrange
    ImmutableCountry.Builder builderResult = ImmutableCountry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.region("us-east-2"));
  }

  /**
   * Method under test: {@link ImmutableCountry.Builder#regionCode(String)}
   */
  @Test
  void testBuilderRegionCode() {
    // Arrange
    ImmutableCountry.Builder builderResult = ImmutableCountry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.regionCode("us-east-2"));
  }

  /**
   * Method under test: {@link ImmutableCountry#copyOf(Country)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Country instance = mock(Country.class);
    when(instance.regionCode()).thenReturn("us-east-2");
    when(instance.region()).thenReturn("us-east-2");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCountry actualCopyOfResult = ImmutableCountry.copyOf(instance);

    // Assert
    verify(instance).code();
    verify(instance).name();
    verify(instance).region();
    verify(instance).regionCode();
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("us-east-2", actualCopyOfResult.region());
    assertEquals("us-east-2", actualCopyOfResult.regionCode());
  }
}
