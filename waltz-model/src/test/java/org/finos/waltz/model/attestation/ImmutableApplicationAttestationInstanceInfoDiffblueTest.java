package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class ImmutableApplicationAttestationInstanceInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceInfo.Builder#filters(ApplicationAttestationSummaryFilters)}
   */
  @Test
  void testBuilderFilters() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult = ImmutableApplicationAttestationInstanceInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.filters(new ImmutableApplicationAttestationSummaryFilters.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceInfo.Builder#from(ApplicationAttestationInstanceInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult = ImmutableApplicationAttestationInstanceInfo
        .builder();
    ApplicationAttestationInstanceInfo instance = mock(ApplicationAttestationInstanceInfo.class);
    ImmutableApplicationAttestationSummaryFilters.Json json = new ImmutableApplicationAttestationSummaryFilters.Json();
    when(instance.filters()).thenReturn(json);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableApplicationAttestationInstanceInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).filters();
    verify(instance).selectionOptions();
    assertSame(json, builderResult.build().filters());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceInfo.Builder#from(ApplicationAttestationInstanceInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult = ImmutableApplicationAttestationInstanceInfo
        .builder();
    ApplicationAttestationInstanceInfo instance = mock(ApplicationAttestationInstanceInfo.class);
    when(instance.filters()).thenThrow(new IllegalStateException("instance"));
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).filters();
    verify(instance).selectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceInfo.Builder#selectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderSelectionOptions() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult = ImmutableApplicationAttestationInstanceInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.selectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceInfo#copyOf(ApplicationAttestationInstanceInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ApplicationAttestationInstanceInfo instance = mock(ApplicationAttestationInstanceInfo.class);
    ImmutableApplicationAttestationSummaryFilters.Json json = new ImmutableApplicationAttestationSummaryFilters.Json();
    when(instance.filters()).thenReturn(json);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableApplicationAttestationInstanceInfo actualCopyOfResult = ImmutableApplicationAttestationInstanceInfo
        .copyOf(instance);

    // Assert
    verify(instance).filters();
    verify(instance).selectionOptions();
    assertSame(json, actualCopyOfResult.filters());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceInfo#fromJson(ImmutableApplicationAttestationInstanceInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Json json = new ImmutableApplicationAttestationInstanceInfo.Json();
    json.setSelectionOptions(mock(IdSelectionOptions.class));
    ImmutableApplicationAttestationSummaryFilters.Json filters = new ImmutableApplicationAttestationSummaryFilters.Json();
    json.setFilters(filters);

    // Act
    ImmutableApplicationAttestationInstanceInfo actualFromJsonResult = ImmutableApplicationAttestationInstanceInfo
        .fromJson(json);

    // Assert
    assertSame(filters, actualFromJsonResult.filters());
    IdSelectionOptions expectedSelectionOptionsResult = json.selectionOptions;
    assertSame(expectedSelectionOptionsResult, actualFromJsonResult.selectionOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceInfo.Json#filters()}
   */
  @Test
  void testJsonFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationInstanceInfo.Json()).filters());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableApplicationAttestationInstanceInfo.Json}
   *   <li>
   * {@link ImmutableApplicationAttestationInstanceInfo.Json#setFilters(ApplicationAttestationSummaryFilters)}
   *   <li>
   * {@link ImmutableApplicationAttestationInstanceInfo.Json#setSelectionOptions(IdSelectionOptions)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableApplicationAttestationInstanceInfo.Json actualJson = new ImmutableApplicationAttestationInstanceInfo.Json();
    actualJson.setFilters(new ImmutableApplicationAttestationSummaryFilters.Json());
    actualJson.setSelectionOptions(null);

    // Assert
    assertFalse(((ImmutableApplicationAttestationSummaryFilters.Json) actualJson.filters).appCriticality.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationInstanceInfo.Json#selectionOptions()}
   */
  @Test
  void testJsonSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationInstanceInfo.Json()).selectionOptions());
  }
}
